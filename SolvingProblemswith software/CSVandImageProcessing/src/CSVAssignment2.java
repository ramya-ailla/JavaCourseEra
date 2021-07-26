import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVAssignment2 {
    CSVRecord coldestHourInFile(CSVParser parser){
        //returns record with min Temperature in a CSV file
        CSVRecord coldestHourRecord = null;
        for(CSVRecord currRecord:parser){
            if(coldestHourRecord == null){
                coldestHourRecord = currRecord;
            }
            else{
                coldestHourRecord = coldestOftheTwo(coldestHourRecord,currRecord);

            }
        }
        return coldestHourRecord;
    }
    CSVRecord coldestOftheTwo(CSVRecord record1,CSVRecord record2){
        //it compares temperatures of two records and returns records with minimum temperature
        if(Double.parseDouble(record1.get("TemperatureF")) > Double.parseDouble(record2.get("TemperatureF"))){
            return record2;
        }
        else
            return record1;
    }
    File fileWithColdestTemperature(){
        //returns file containing coldest Temperature
        File coldestDayFile = null;
        CSVRecord coldestRecord = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser p = fr.getCSVParser();
            CSVRecord coldestRecordInCurrentFile = coldestHourInFile(p);
            if(coldestRecord == null){
                coldestDayFile = f;
                coldestRecord = coldestRecordInCurrentFile;
                }
            else{
                coldestRecord = coldestOftheTwo(coldestRecordInCurrentFile,coldestRecord);
                if(coldestRecord == coldestRecordInCurrentFile){
                    coldestDayFile = f;
                }
            }
        }
        return coldestDayFile;
    }

    double averageTemperatureInaFile(CSVParser parser){
        double sumTemp = 0.0;
        for(CSVRecord record : parser){
                sumTemp += Double.parseDouble(record.get("TemperatureF"));
        }
        return sumTemp/24.0;
    }

    void testFileWithColdestTemperature(){
        File f= fileWithColdestTemperature();
        System.out.println("Coldest Day was in file "+f.getName());
        FileResource fr = new FileResource(f);
        CSVParser p = fr.getCSVParser();
        CSVRecord r = coldestHourInFile(p);
        System.out.println("Coldest temperature on that day was "+r.get("TemperatureF"));
        p = fr.getCSVParser();
        for(CSVRecord record:p){
            System.out.println(record.get("DateUTC")+" "+record.get("TemperatureF"));
        }

    }

    void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("coldest hour is at "+coldestHourInFile(parser).get("TimeEST"));
    }

    void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser p = fr.getCSVParser();
        System.out.println("Average Temperature is "+ averageTemperatureInaFile(p));
    }
    public static void main(String [] args){
        CSVAssignment2 o = new CSVAssignment2();
        //o.testColdestHourInFile();
        //o.testFileWithColdestTemperature();
        o.testAverageTemperatureInFile();
    }

}
