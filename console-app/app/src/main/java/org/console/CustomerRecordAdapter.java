package org.console;

import java.util.ArrayList;
import java.util.List;

public class CustomerRecordAdapter {
    private List<CustomerRecord> customerList;

    public CustomerRecordAdapter(){
        customerList = new ArrayList<>();
    }

    public void createRecordsFromFileData(List<String[]> data)
    {
        if(data.size() <= 0) {
            System.out.println("No data from CSV to convert.");
            return;
        }

        // TODO: convert string elements to CustomerRecords
    }

    public List<CustomerRecord> getRecords()
    {
        return customerList;
    }
}
