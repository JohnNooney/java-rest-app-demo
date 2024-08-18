package org.console.csv;

import java.util.ArrayList;
import java.util.List;

public class CSVData {
    private List<String[]> csvListData;
    
    public CSVData() {
        csvListData = new ArrayList<>();
    } 

    public void addLineData(String line){
        String[] values = line.split(",");
        csvListData.add(values);
    }

    public List<String[]> getLinesAsList(){
        return csvListData;
    }
}
