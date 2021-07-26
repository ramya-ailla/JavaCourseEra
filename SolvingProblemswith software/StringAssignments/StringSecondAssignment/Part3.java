public class Part3 {
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
    void printAllGenes(String dna){
        int index = 0;
        while(true){
            String gene = findGene(dna.substring(index));
            if(gene.isEmpty()){
                break;
            }
            System.out.println("Genes are "+gene);
            index = dna.indexOf(gene)+gene.length();
        }
    }
    int countGenes(String dna){
        int index = 0,count =0;
        while(true){
            String gene = findGene(dna.substring(index));
            if(gene.isEmpty()){
                break;
            }
            count++;
            index = dna.indexOf(gene)+gene.length();
        }
        return count;
    }
    void testCountGene(){
        System.out.println(countGenes("ATGGCTTAAGTAATGATGAAGTAG"));
    }
    public static void main(String [] args){
        Part3 obj = new Part3();
        obj.testCountGene();
    }
}
