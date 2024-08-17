package com.java_rest_app.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Integer customerRef;
    
    private String customerName;
    private String addressLine1;
    private String addressLine2;
    private String county;
    private String town;
    private String country;
    private String postcode;
}
