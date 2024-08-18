package com.java_rest_app.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        return customerService.newCustomer(customer);
    }

    @GetMapping("/customer/{customerRef}")
    public ResponseEntity<Object> getCustomerByRef(@PathVariable Integer customerRef) {
        return customerService.getCustomer(customerRef);
    }


}
