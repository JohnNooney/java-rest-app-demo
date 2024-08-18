package com.java_rest_app.demo.customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

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

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getCustomer(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(!customerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Customer customer = customerOptional.get();
        return ResponseEntity.ok(customer);
    }
}
