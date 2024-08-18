package org.console.customer;

import org.console.csv.CSVData;

import java.util.ArrayList;
import java.util.List;

public class CustomerRecordAdapter {
    private List<CustomerRecord> customerList;
    private CustomerRecordValidator validator;

    public CustomerRecordAdapter(){
        customerList = new ArrayList<>();
        validator = new CustomerRecordValidator();
    }

    public void createRecordsFromFileData(CSVData csvData)
    {
        List<String[]> csvList = csvData.getLinesAsList();

        if(csvList.size() == 0) {
            System.out.println("No data from CSV to convert.");
            return;
        }

        csvList.forEach(csvRecord -> {
            CustomerRecord record;
            
            try {
                record = CustomerRecord.builder()
                    .setCustomerRef(Integer.parseInt(csvRecord[0]))
                    .setCustomerName(csvRecord[1])
                    .setAddressLine1(csvRecord[2])
                    .setAddressLine2(csvRecord[3])
                    .setTown(csvRecord[4])
                    .setCounty(csvRecord[5])
                    .setCountry(csvRecord[6])
                    .setPostCode(csvRecord[7])
                    .build(); 
        
                validator.validateRecord(record);

                customerList.add(record);

                System.out.println("Adapter created record:" + String.join(",", csvRecord));
            } catch (Exception ex) {
                System.err.println("Adapter failed to create record:" + String.join(",", csvRecord) + " for reason: " + ex);
            }
        });
    }

    public List<CustomerRecord> getRecordsList()
    {
        return customerList;
    }
}
