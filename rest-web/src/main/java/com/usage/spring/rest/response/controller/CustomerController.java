package com.usage.spring.rest.response.controller;

import com.usage.spring.rest.response.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
public class CustomerController {

    @Autowired
    private DateFormatter dateFormatter;

    @Autowired
    private Locale locale;

    @RequestMapping("/customer/{id}")
    public Customer customer(@PathVariable("id") String customerId) throws ParseException {
        return new Customer( Long.parseLong(customerId),"John", "Smith", dateFormatter.parse("12-01-1998", locale));
    }

    @RequestMapping("/customers")
    public List<Customer> customer() throws ParseException {
        Customer customer1 = new Customer( 1L,"John", "Smith", dateFormatter.parse("12-01-1998", locale));
        Customer customer2 = new Customer( 2L,"Jack", "Sparrow", dateFormatter.parse("12-01-1998", locale));
        return Arrays.asList(new Customer[]{customer1, customer2});
    }
}
