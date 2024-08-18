package com.java_rest_app.demo.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import static org.mockito.Mockito.when;

@WebMvcTest(CustomerController.class)
class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    private Customer expectedCustomer;

    @BeforeEach
    void init() {
        expectedCustomer = new Customer();
        expectedCustomer.setCustomerRef(1);
        expectedCustomer.setCustomerName("John Doe");
        expectedCustomer.setAddressLine1("123 Red Rd.");
        expectedCustomer.setAddressLine2("Apt. 3");
        expectedCustomer.setTown("Townville");
        expectedCustomer.setCounty("Some County");
        expectedCustomer.setCountry("USA");
        expectedCustomer.setPostcode("1234");
    }
    @Test
    void customerShouldBeReturnedFromServiceOnGET() throws Exception {
        when(service.getCustomer(1)).thenReturn(ResponseEntity.ok(expectedCustomer));

        this.mockMvc.perform(get("/api/v1/customer/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("John Doe")));
    }

    @Test
    void customerShouldBeReturnedFromServiceOnPOST() throws Exception {
        when(service.newCustomer(Mockito.any(Customer.class))).thenReturn(new ResponseEntity<>(expectedCustomer, HttpStatus.CREATED));

        String expectedCustomerAsJson = asJsonString(expectedCustomer);

        this.mockMvc.perform(post("/api/v1/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expectedCustomerAsJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(expectedCustomerAsJson)));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
