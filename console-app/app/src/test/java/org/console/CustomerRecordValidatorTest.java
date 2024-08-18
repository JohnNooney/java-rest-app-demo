package org.console;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.console.customer.CustomerRecord;
import org.console.customer.CustomerRecordValidator;
import org.junit.Test;

public class CustomerRecordValidatorTest {
    final Integer customerRefSample = 0;
    final String customerNameSample = "John Doe";
    final String addressLine1Sample = "Somewhere Lane";
    final String addressLine2Sample = "Apt. 3";
    final String countySample = "Some County";
    final String countrySample = "America";
    final String townSample = "Mystery Town";
    final String postCodeSample = "1234";
    final CustomerRecordValidator validator = new CustomerRecordValidator();

    @Test public void validatorThrowsForMissingCustomerRef(){

        CustomerRecord record = CustomerRecord.builder()
            .setCustomerName(customerNameSample)
            .setAddressLine1(addressLine1Sample)
            .setAddressLine2(addressLine2Sample)
            .setCounty(countySample)
            .setCountry(countrySample)
            .setTown(townSample)
            .setPostCode(postCodeSample)
            .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateRecord(record);
        });

        assertEquals(exception.getMessage(), "Customer Ref cannot be null");
    }

    @Test public void validatorThrowsForMissingCustomerName(){
        CustomerRecord record = CustomerRecord.builder()
            .setCustomerRef(customerRefSample)
            .setAddressLine1(addressLine1Sample)
            .setAddressLine2(addressLine2Sample)
            .setCounty(countySample)
            .setCountry(countrySample)
            .setTown(townSample)
            .setPostCode(postCodeSample)
            .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateRecord(record);
        });

        assertEquals(exception.getMessage(), "Customer Name cannot be null");
    }

    @Test public void validatorThrowsForMissingAddressLine1(){
        CustomerRecord record = CustomerRecord.builder()
            .setCustomerRef(customerRefSample)
            .setCustomerName(customerNameSample)
            .setAddressLine2(addressLine2Sample)
            .setCounty(countySample)
            .setCountry(countrySample)
            .setTown(townSample)
            .setPostCode(postCodeSample)
            .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateRecord(record);
        });

        assertEquals(exception.getMessage(), "Address Line 1 cannot be null");
    }

    @Test public void validatorThrowsForMissingAddressLine2(){
        CustomerRecord record = CustomerRecord.builder()
            .setCustomerRef(customerRefSample)
            .setCustomerName(customerNameSample)
            .setAddressLine1(addressLine1Sample)
            .setCounty(countySample)
            .setCountry(countrySample)
            .setTown(townSample)
            .setPostCode(postCodeSample)
            .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateRecord(record);
        });

        assertEquals(exception.getMessage(), "Address Line 2 cannot be null");
    }

    @Test public void validatorThrowsForMissingCounty(){
        CustomerRecord record = CustomerRecord.builder()
            .setCustomerRef(customerRefSample)
            .setCustomerName(customerNameSample)
            .setAddressLine1(addressLine1Sample)
            .setAddressLine2(addressLine2Sample)
            .setCountry(countrySample)
            .setTown(townSample)
            .setPostCode(postCodeSample)
            .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateRecord(record);
        });

        assertEquals(exception.getMessage(), "County cannot be null");
    }

    @Test public void validatorThrowsForMissingCountry(){
        CustomerRecord record = CustomerRecord.builder()
            .setCustomerRef(customerRefSample)
            .setCustomerName(customerNameSample)
            .setAddressLine1(addressLine1Sample)
            .setAddressLine2(addressLine2Sample)
            .setCounty(countySample)
            .setTown(townSample)
            .setPostCode(postCodeSample)
            .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateRecord(record);
        });

        assertEquals(exception.getMessage(), "Country cannot be null");
    }

    @Test public void validatorThrowsForMissingTown(){
        CustomerRecord record = CustomerRecord.builder()
            .setCustomerRef(customerRefSample)
            .setCustomerName(customerNameSample)
            .setAddressLine1(addressLine1Sample)
            .setAddressLine2(addressLine2Sample)
            .setCounty(countySample)
            .setCountry(countrySample)
            .setPostCode(postCodeSample)
            .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateRecord(record);
        });

        assertEquals(exception.getMessage(), "Town cannot be null");
    }

    @Test public void validatorThrowsForMissingPostCode(){
        CustomerRecord record = CustomerRecord.builder()
            .setCustomerRef(customerRefSample)
            .setCustomerName(customerNameSample)
            .setAddressLine1(addressLine1Sample)
            .setAddressLine2(addressLine2Sample)
            .setCounty(countySample)
            .setCountry(countrySample)
            .setTown(townSample)
            .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateRecord(record);
        });

        assertEquals(exception.getMessage(), "Postcode cannot be null");
    }
}
