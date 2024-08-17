package test.java.org.console;

import org.junit.Test;

import main.java.org.console.CSVReader;
import main.java.org.console.CustomerRecord;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerRecordAdapterTest {
     @Test public void createRecordsFromCSVFile(){
        List<String[]> sampleCsvData = new ArrayList<>();
        sampleCsvData.add(new String[]{"1", "John Doe", "123 Main Street", "Apt 2", "Anytown", "Some County", "USA", "12345"});

        List<CustomerRecord> customerRecords = reader.getRecords();
    }
}
