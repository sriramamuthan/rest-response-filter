package com.usage.spring.rest.response.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.usage.spring.rest.response.processor.Enrich;
import lombok.Data;

import java.util.Date;

@Data
public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

    @Enrich(addfields = {"firstName","lastName"} , delimiter = " ")
    private String fullName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    public Customer(Long id, String firstName, String lastName, Date dateOfBirth){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
