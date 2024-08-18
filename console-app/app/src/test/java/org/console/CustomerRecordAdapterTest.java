package org.console;

import org.console.csv.CSVData;
import org.console.customer.CustomerRecord;
import org.console.customer.CustomerRecordAdapter;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class CustomerRecordAdapterTest {
    CustomerRecord expectedRecord = CustomerRecord.builder()
        .setCustomerRef(5)
        .setCustomerName("John Doe")
        .setAddressLine1("123 Main Street")
        .setAddressLine2("Apt 2")
        .setCounty("Some County")
        .setCountry("USA")
        .setTown("Anytown")
        .setPostCode("12345")
        .build(); 
    
     @Test public void createRecordsFromCSVDataHandlesIncorrectCustomerRef(){
        CustomerRecordAdapter adapter = new CustomerRecordAdapter();
        CSVData csvData = new CSVData();
        csvData.addLineData("wrongref,John Doe,123 Main Street,Apt 2,Anytown,Some County,USA,12345");

        adapter.createRecordsFromFileData(csvData);

        assertEquals(0, adapter.getRecordsList().size());
    }

    @Test public void createRecordsFromCSVDataHandlesEmptyData(){
        CustomerRecordAdapter adapter = new CustomerRecordAdapter();
        CSVData csvData = new CSVData();
        csvData.addLineData(", , , , , , ,");

        adapter.createRecordsFromFileData(csvData);

        assertEquals(0, adapter.getRecordsList().size());
    }

    @Test public void createRecordsFromCSVDataHandlesUnexpectedData(){
        CustomerRecordAdapter adapter = new CustomerRecordAdapter();
        CSVData csvData = new CSVData();
        csvData.addLineData("1,/,?,|,...., ,__,");

        adapter.createRecordsFromFileData(csvData);

        assertEquals(0, adapter.getRecordsList().size());
    }

    @Test public void createRecordsFromCSVDataHandlesNoData(){
        CustomerRecordAdapter adapter = new CustomerRecordAdapter();
        CSVData csvData = new CSVData();
        csvData.addLineData("");

        adapter.createRecordsFromFileData(csvData);

        assertEquals(0, adapter.getRecordsList().size());
    }

    @Test public void createRecordsFromCSVDataHandlesExpectedData(){
        CustomerRecordAdapter adapter = new CustomerRecordAdapter();
        CSVData csvData = new CSVData();
        csvData.addLineData("1,John Doe,123 Main Street,Apt 2,Anytown,Some County,USA,12345");

        adapter.createRecordsFromFileData(csvData);

        assertEquals(1, adapter.getRecordsList().size());
    }

    @Test public void createRecordsFromCSVDataReturnsExpectedData(){
        CustomerRecordAdapter adapter = new CustomerRecordAdapter();

        CSVData csvData = new CSVData();
        csvData.addLineData("5,John Doe,123 Main Street,Apt 2,Anytown,Some County,USA,12345");

        adapter.createRecordsFromFileData(csvData);
        List<CustomerRecord> records = adapter.getRecordsList();

        assertEquals(1, adapter.getRecordsList().size());
        assertEquals(expectedRecord.getCustomerRef(), records.get(0).getCustomerRef());
        assertEquals(expectedRecord.getCustomerName(), records.get(0).getCustomerName());
        assertEquals(expectedRecord.getAddressLine1(), records.get(0).getAddressLine1());
        assertEquals(expectedRecord.getAddressLine2(), records.get(0).getAddressLine2());
        assertEquals(expectedRecord.getCounty(), records.get(0).getCounty());
        assertEquals(expectedRecord.getTown(), records.get(0).getTown());
        assertEquals(expectedRecord.getCountry(), records.get(0).getCountry());
        assertEquals(expectedRecord.getPostCode(), records.get(0).getPostCode());
    }
}
