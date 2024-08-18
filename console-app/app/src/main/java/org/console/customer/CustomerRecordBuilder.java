package org.console.customer;

public class CustomerRecordBuilder {
    public Integer customerRef;
    public String customerName;
    public String addressLine1;
    public String addressLine2;
    public String town;
    public String county;
    public String country;
    public String postcode;

    public CustomerRecordBuilder setCustomerRef(Integer customerRef) {
        this.customerRef = customerRef;
        return this;
    }

    public CustomerRecordBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CustomerRecordBuilder setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public CustomerRecordBuilder setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public CustomerRecordBuilder setTown(String town) {
        this.town = town;
        return this;
    }

    public CustomerRecordBuilder setCounty(String county) {
        this.county = county;
        return this;
    }

    public CustomerRecordBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public CustomerRecordBuilder setPostCode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public CustomerRecord build() {

        return new CustomerRecord(this);
    }
}
