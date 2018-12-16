package com.usage.spring.rest.response.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;

import java.util.Locale;

@Configuration
public class Config {

    @Bean
    public DateFormatter dateFormatter(){
        return new DateFormatter("dd-MM-yyyy");
    }

    @Bean
    public Locale locale(){
        return new Locale("en_US");
    }
}
