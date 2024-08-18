package com.java_rest_app.demo.customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Object> newCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (Exception ex) {
            System.out.println("Unable to create customer record for reason: " + ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save customer");
        }

        System.out.println("Created customer record with reference: " + customer.getCustomerRef());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getCustomer(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(!customerOptional.isPresent()) {
            System.out.println("Customer record not found for reference: " + id.toString());
            return ResponseEntity.notFound().build();
        }

        Customer customer = customerOptional.get();

        System.out.println("Customer found with reference: " + customer.getCustomerRef());
        return ResponseEntity.ok(customer);
    }
}
