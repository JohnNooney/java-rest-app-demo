package test.java.org.console;

import org.junit.Test;
import main.java.org.console.CustomerRecord;
import static org.junit.Assert.*;

public class CustomerRecordBuilderTest {
    @Test public void builderReturnsCustomerRecord(){
        CustomerRecord record = CustomerRecord.builder()
            .build();
        
        assertNotNull("CustomerRecord should be returned", record);
    }

    @Test public void builderReturnsExpectedCustomerRecord(){
        CustomerRecord record = CustomerRecord.builder()
            .setCustomerRef(0)
            .setCustomerName("John Doe")
            .setAddressLine1("Somewhere Lane")
            .setAddressLine2("Apt. 3")
            .setCountry("America")
            .setTown("Mystery Town")
            .build();
        
        assertEquals("Customer Ref should be 0", record.getCustomerRef(), 0);
        assertEquals("Customer Name should be John Doe", record.getCustomerName(), "John Doe");
        assertEquals("Address Line 1 should be Somewhere Lane", record.getAddressLine1(), "Somewhere Lane");
        assertEquals("Address Line 2 should be Apt. 3", record.getAddressLine2(), "Apt. 3");
        assertEquals("Country should be America", record.getCountry(), "America");
        assertEquals("Town should be Mystery Town", record.getTown(), "Mystery Town");
    }
}
