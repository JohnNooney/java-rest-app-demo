package org.console;

public class CustomerRecordValidator {
    public void validateRecord(CustomerRecord record) throws IllegalArgumentException{
        validateCustomerRef(record.getCustomerRef());
        validateCustomerName(record.getCustomerName());
        validateAddressLine1(record.getAddressLine1());
        validateAddressLine2(record.getAddressLine2());
        validateCountry(record.getCountry());
        validateTown(record.getTown());
        validatePostCode(record.getPostCode());
    }

    private void validateCustomerRef(Integer customerRef) {
        if (customerRef == null) {
            throw new IllegalArgumentException("Customer Ref cannot be null");
        }
    }

    private void validateCustomerName(String customerName) {
        if (customerName == null) {
            throw new IllegalArgumentException("Customer Name cannot be null");
        }
    }

    private void validateAddressLine1(String addressLine) {
        if (addressLine == null) {
            throw new IllegalArgumentException("Address Line 1 cannot be null");
        }
    }

    private void validateAddressLine2(String addressLine) {
        if (addressLine == null) {
            throw new IllegalArgumentException("Address Line 2 cannot be null");
        }
    }

    private void validateCountry(String country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
    }

    private void validateTown(String town) {
        if (town == null) {
            throw new IllegalArgumentException("Town cannot be null");
        }
    }

    private void validatePostCode(String postcode) {
        if (postcode == null) {
            throw new IllegalArgumentException("Postcode cannot be null");
        }
    }
}
