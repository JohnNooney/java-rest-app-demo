package test.java.org.console;

import org.junit.Test;

import main.java.org.console.CSVReader;
import main.java.org.console.CustomerRecord;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

public class CSVReaderTest {
    private String workingDirectory = System.getProperty("user.dir");

    @Test public void readNonexistentFileReturnsEmptyCSVData(){
        CSVReader reader = new CSVReader();
        
        List<String[]> csvListData = reader.readFile("./fake/file.csv");

        assertEquals(0, csvListData.size());
    }

    @Test public void readFileReturnsExpectedCSVData(){
        CSVReader reader = new CSVReader();

        List<String[]> csvListData = reader.readFile(workingDirectory + "/src/test/resources/test-data.csv");
        
        //Expected Record: 1,John Doe,123 Main Street,Apt 2,Anytown,Some County,USA,12345
        assertEquals("1", csvListData.get(1)[0]);
        assertEquals("John Doe", csvListData.get(1)[1]);
        assertEquals("123 Main Street", csvListData.get(1)[2]);
        assertEquals("Apt 2", csvListData.get(1)[3]);
        assertEquals("Anytown", csvListData.get(1)[4]);
        assertEquals("Some County", csvListData.get(1)[5]);
        assertEquals("USA", csvListData.get(1)[6]);
        assertEquals("12345", csvListData.get(1)[7]);
    }
}
