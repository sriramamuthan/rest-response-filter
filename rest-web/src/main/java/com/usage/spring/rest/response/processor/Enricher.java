package com.usage.spring.rest.response.processor;

public interface Enricher {

    void enrich(Object responseEntity);
}
