package org.console;

import org.console.customer.CustomerRecord;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerRecordBuilderTest {
    final Integer customerRefSample = 0;
    final String customerNameSample = "John Doe";
    final String addressLine1Sample = "Somewhere Lane";
    final String addressLine2Sample = "Apt. 3";
    final String countrySample = "America";
    final String townSample = "Mystery Town";
    final String postCodeSample = "1234";


    @Test public void builderReturnsCustomerRecord(){
        CustomerRecord record = CustomerRecord.builder()
            .build();
        
        assertNotNull("CustomerRecord should be returned", record);
    }

    @Test public void builderReturnsExpectedCustomerRecord(){
        CustomerRecord record = CustomerRecord.builder()
            .setCustomerRef(customerRefSample)
            .setCustomerName(customerNameSample)
            .setAddressLine1(addressLine1Sample)
            .setAddressLine2(addressLine2Sample)
            .setCountry(countrySample)
            .setTown(townSample)
            .setPostCode(postCodeSample)
            .build();
        
        assertEquals("Customer Ref should be " + Integer.toString(customerRefSample), record.getCustomerRef(), customerRefSample);
        assertEquals("Customer Name should be " + customerNameSample, record.getCustomerName(), customerNameSample);
        assertEquals("Address Line 1 should be " + addressLine1Sample, record.getAddressLine1(), addressLine1Sample);
        assertEquals("Address Line 2 should be " + addressLine2Sample, record.getAddressLine2(), addressLine2Sample);
        assertEquals("Country should be " + countrySample, record.getCountry(), countrySample);
        assertEquals("Town should be " + townSample, record.getTown(), townSample);
        assertEquals("Postcode should be " + postCodeSample, record.getPostCode(), postCodeSample);
    }
}
