import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyNames {
        public void printNames () {
            FileResource fr = new FileResource();
            for (CSVRecord rec : fr.getCSVParser(false)) {
                int numBorn = Integer.parseInt(rec.get(2));
                if (numBorn <= 100) {
                    System.out.println("Name " + rec.get(0) +
                            " Gender " + rec.get(1) +
                            " Num Born " + rec.get(2));
                }
            }
        }

        public void totalBirths (FileResource fr) {
            int totalBirths = 0;
            int totalBoys = 0;
            int totalGirls = 0;
            for (CSVRecord rec : fr.getCSVParser(false)) {
                int numBorn = Integer.parseInt(rec.get(2));
                totalBirths += numBorn;
                if (rec.get(1).equals("M")) {
                    totalBoys += numBorn;
                }
                else {
                    totalGirls += numBorn;
                }
            }
            System.out.println("total births = " + totalBirths);
            System.out.println("female girls = " + totalGirls);
            System.out.println("male boys = " + totalBoys);
        }
       int getRank(int year,String name,String gender){
            FileResource fr = new FileResource("yob"+year+".csv");
            return getRankInfile("Mason","M",fr);

        }
        int getRankInfile(String name,String gender,FileResource fr){
            int rank =0;
            boolean found = false;
            for(CSVRecord record:fr.getCSVParser(false)){
                if(record.get(1).equals(gender)){
                    rank++;
                    if(record.get(0).equals(name)){
                        found = true;
                        break;
                    }
                }
            }
            if(found){
                return rank;
            }
            else
                return -1;

        }
        String getName(int year,int rank,String gender){
            //returns the name with the gender , rank specified born in the year specified
            FileResource fr = new FileResource("yob"+year+".csv");
            return getNameInFile(rank,gender,fr);

        }
        String getNameInFile(int rank,String gender,FileResource fr){
            int currRank=0;
            for(CSVRecord r:fr.getCSVParser(false)){
                if(r.get(1).equals(gender)){
                    currRank++;
                    if(currRank==rank){
                        return r.get(0);
                    }
                }
            }
            return "NO NAME";
        }
        void whatIsNameInYear(String name,int year,int newYear,String gender){
            int rank = getRank(year,name,gender);
            String newName =getName(newYear,rank,gender);
            System.out.println(newName);
        }
        int yearOfHighestRank(String name,String gender){
            int rank =Integer.MAX_VALUE;
            int year=-1;
            DirectoryResource dr = new DirectoryResource();
            for(File f:dr.selectedFiles()){
                FileResource fr = new FileResource(f);
                int currRank = getRankInfile(name,gender,fr);
                if(rank > currRank) {
                    rank = currRank;
                    year = Integer.parseInt(f.getName().substring(3, 7));
                }
            }
            return year;
        }
        double avgRank(String name,String gender){
            int sumRank=0,fileCount=0;
            DirectoryResource dr = new DirectoryResource();
            for(File f:dr.selectedFiles()){
                fileCount++;
                FileResource fr = new FileResource(f);
                int currRank = getRankInfile(name,gender,fr);
                if(currRank == -1){
                    return -1;
                }
                sumRank+=currRank;
            }
            return sumRank/(double)fileCount;

        }
        void testTotalBirths () {
            //FileResource fr = new FileResource();
            FileResource fr = new FileResource("yob2014.csv");
            totalBirths(fr);
        }
        int getTotalBirthsRankedHigher(int year,String name,String gender){
            FileResource fr = new FileResource("yob"+2012+"short.csv");
            int totBirths =0;
            for(CSVRecord r:fr.getCSVParser()){
                if(r.get(1).equals(gender)){
                    if (r.get(0).equals(name)){
                        break;
                    }
                    totBirths += Integer.parseInt(r.get(2));
                    }
            }
            return totBirths;
        }
        public static void main(String [] args){
            BabyNames o = new BabyNames();
            //o.testTotalBirths();
            //System.out.println(o.getRank(2012,"Mason","M"));
            //System.out.println(o.getName(2012,2,"M"));
            //o.whatIsNameInYear("Mason",2012,2014,"M");
            //System.out.println(o.yearOfHighestRank("Mason","M"));
            //System.out.println(o.avgRank("Mason","M"));
            System.out.println(o.getTotalBirthsRankedHigher(2012,"Ethan","M"));
        }
    }
