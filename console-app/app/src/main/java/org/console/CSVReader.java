package org.console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class CSVReader {
    private CSVData data;

    public CSVReader() {
        data = new CSVData();
    }

    public List<String[]> readFile(String filePath)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println("CSV line: " + line);
                data.addLineData(line);
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        return data.getLineData();
    }
}
