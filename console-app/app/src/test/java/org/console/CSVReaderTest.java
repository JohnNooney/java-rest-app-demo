package org.console;

import org.junit.Test;
import static org.junit.Assert.*;


public class CSVReaderTest {
    private String workingDirectory = System.getProperty("user.dir");

    @Test public void readNonexistentFileReturnsEmptyCSVData(){
        CSVReader reader = new CSVReader();
        
        CSVData data = reader.readFile("./fake/file.csv");

        assertEquals(0, data.getLinesAsList().size());
    }

    @Test public void readFileReturnsExpectedCSVData(){
        CSVReader reader = new CSVReader();

        CSVData csvData = reader.readFile(workingDirectory + "/src/test/resources/test-data.csv");
        
        //Expected Record: 1,John Doe,123 Main Street,Apt 2,Anytown,Some County,USA,12345
        assertEquals("1", csvData.getLinesAsList().get(0)[0]);
        assertEquals("John Doe", csvData.getLinesAsList().get(0)[1]);
        assertEquals("123 Main Street", csvData.getLinesAsList().get(0)[2]);
        assertEquals("Apt 2", csvData.getLinesAsList().get(0)[3]);
        assertEquals("Anytown", csvData.getLinesAsList().get(0)[4]);
        assertEquals("Some County", csvData.getLinesAsList().get(0)[5]);
        assertEquals("USA", csvData.getLinesAsList().get(0)[6]);
        assertEquals("12345", csvData.getLinesAsList().get(0)[7]);
    }
}
