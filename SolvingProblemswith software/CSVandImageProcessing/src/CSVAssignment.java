import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVAssignment {
    void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser,"Nauru"));
        //listExportersTwoProducts(parser,"fish","nuts");
        //System.out.println("number of countries who exports sugar are "+numberOfExporters(parser,"sugar"));
        bigExporters(parser,"$999,999,999,999");
    }
    String countryInfo(CSVParser p,String country){
        //returns country's record
        for(CSVRecord record:p){
            if(country.equals(record.get("Country"))){
                return country+" : "+record.get("Exports")+" : "+record.get("Value (dollars)");
            }
        }
        return country+" : "+"NOT FOUND";
    }
    void listExportersTwoProducts(CSVParser p,String exportItem1,String exportItem2){
        //prints country's names who export both the items
        for(CSVRecord record :p){
            if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    int numberOfExporters(CSVParser p,String exportItem){
        //returns number of countries which exports the specified item
        int cCount=0;
        for(CSVRecord record : p){
            if(record.get("Exports").contains(exportItem)){
                cCount++;
            }
        }
        return cCount;
    }
    void bigExporters(CSVParser p, String amount){
        //prints names of those countries whose Value String  is longer than the amount string
        for(CSVRecord record:p){
            if(record.get("Value (dollars)").length() > amount.length()){
                System.out.println(record.get("Country")+record.get("Value (dollars)"));
            }
        }
    }
    public static void main(String [] args){
        CSVAssignment o= new CSVAssignment();
        o.tester();
    }
}
