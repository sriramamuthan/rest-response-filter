package com.usage.spring.rest.response.controller;

import com.usage.spring.rest.response.config.Config;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
@ContextConfiguration(classes = Config.class)
@ComponentScan(basePackages = "com.usage.spring.rest")
public class CustomerControllerTests {

    @Autowired
    WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getCustomer() throws Exception {
        mockMvc.perform(get("/customer/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", IsEqual.equalTo("John Smith")));
    }

    @Test
    public void contextLoads() {
        assertNotNull(context);
    }

}
