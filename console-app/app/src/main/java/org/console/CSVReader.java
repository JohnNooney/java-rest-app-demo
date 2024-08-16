package main.java.org.console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private List<CustomerRecord> customerList;

    public CSVReader() {
        customerList = new ArrayList<>();
    }

    public void readFile(String fileName)
    {

    }

    public List<CustomerRecord> getRecords()
    {
        return customerList;
    }
}
