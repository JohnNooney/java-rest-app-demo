package org.console;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader {
    private CSVData data;

    public CSVReader() {
        data = new CSVData();
    }

    public CSVData readFile(String filePath)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // skip csv header
            br.readLine(); 

            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println("CSV line: " + line);
                data.addLineData(line);
            }

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        return data;
    }
}
