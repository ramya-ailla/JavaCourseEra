import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part3 {
    float cgRatio(String dna){
        int count = 0;
        dna = dna.toLowerCase();
        int totalLength = dna.length();
        for(int i =0;i<dna.length();i++){
            if(dna.charAt(i) == 'c'|| dna.charAt(i) =='g'){
                count++;
            }
        }
        return count/(float)totalLength;
    }
    void processGenes(StorageResource sr){
        int sCountL=0,sCountCG=0,lonStringLength=0;
        for(String s:sr.data()){
            if(s.length()>lonStringLength){
                lonStringLength = s.length();
            }
            if(s.length()>60){
                System.out.println("gene with length is greater than 60: "+s);
                sCountL++;
            }
            if(cgRatio(s) > 0.35){
                System.out.println("gene with C-G Ratio greater than 0.35 : "+s);
                sCountCG++;
            }
        }
        System.out.println("Longest gene length: "+lonStringLength);
        System.out.println("no of genes whose length is greater than 60 :"+sCountL);
        System.out.println("no of genes whose C-G Ratio is greater than 0.35 :"+sCountCG);
    }
    void testProcessGenes(){
        StorageResource sr = new StorageResource();
        FileResource fr = new FileResource();
        String dna = fr.asString();
        sr.add(dna);
        processGenes(sr);

    }
    public static void main(String [] args){
        Part3 p = new Part3();
        p.testProcessGenes();
    }
}
