import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import edu.duke.StorageResource;

public class Part1 {
    int findStopCodonIndex(String dna,int startIndex,String stopCodon){
        int currIndex=dna.indexOf(stopCodon,startIndex+3);
        while(currIndex != -1){
            if((currIndex - startIndex-3) % 3 ==0)
                return currIndex;
            else
                currIndex = dna.indexOf(stopCodon,currIndex+1);
        }
        return dna.length();
    }
    String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int indexTAAStopCodon = findStopCodonIndex(dna,startIndex,"TAA");
        int indexTGAStopCodon = findStopCodonIndex(dna,startIndex,"TGA");
        int indexTAGStopCodon = findStopCodonIndex(dna,startIndex,"TAG");

        int minStopCodonIndex = Math.min(indexTAAStopCodon,Math.min(indexTAGStopCodon,indexTGAStopCodon));
        if (minStopCodonIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex,minStopCodonIndex+3);
    }
    StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int index = 0;
        while(true){
            String gene = findGene(dna.substring(index));
            if(gene.isEmpty()){
                break;
            }
            geneList.add(gene);
            index = dna.indexOf(gene)+gene.length();
        }
        return geneList;
    }
    void testGetAllGenes(){
        StorageResource geneList = getAllGenes("ATGGCTTAAGTAATGATGAAGTAG");
        for(String gene:geneList.data()){
            System.out.println(gene);
        }
    }
    public static void main(String [] args){
        Part1 o = new Part1();
        o.testGetAllGenes();

    }
}
