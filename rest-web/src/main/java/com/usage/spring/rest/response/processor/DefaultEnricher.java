package com.usage.spring.rest.response.processor;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Component
public class DefaultEnricher implements Enricher {

    @Override
    public void enrich(Object responseEntity) {
        if(responseEntity instanceof List){
            List list = (List)responseEntity;
            for(Object item : list){
                enrichEntity(item);
            }
        }else{
            enrichEntity(responseEntity);
        }
    }

    private void enrichEntity(Object responseEntity) {
        List<Field> fields = FieldUtils.getFieldsListWithAnnotation(responseEntity.getClass(), Enrich.class);
        for(Field field : fields){
            try {
                Enrich annotation = field.getAnnotation(Enrich.class);
                field.setAccessible(true);
                FieldUtils.writeField(field, responseEntity, getValue(responseEntity, annotation.addfields(), annotation.delimiter()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private String getValue(Object responseEntity, String[] fields, String delimiter){
        StringBuilder result = new StringBuilder();
        Arrays.stream(fields).forEach(field -> {
            try {
                result.append(FieldUtils.readField(responseEntity, field, true));
                result.append(delimiter);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return result.toString().trim();
    }
}
