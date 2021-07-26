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
    void testFindStopCodon(){
        System.out.println(findStopCodonIndex("ATGGGTTTATAA",0,"TAA"));//9
        System.out.println(findStopCodonIndex("ATGGGGAAATTTTGAT",0,"TGA"));//12
        System.out.println(findStopCodonIndex("ATGGTATGAGGGTAGG",0,"TAG"));//12
        System.out.println(findStopCodonIndex("TATGGGTTTATAA",1,"TAA"));//10
    }
    void testFindGene(){
        System.out.println("dna : CATGAAATG\tgene :\t"+findGene("CATGAAATG"));
        System.out.println("dna : TGACAATAA\tgene :\t"+findGene("TGACAATAA"));
        System.out.println("dna : AGGATGAATGTATAA\tgene :\t"+findGene("AGGATGAATGTATAA"));
        System.out.println("dna : GTCATGAAGTATAAGTAA\tgene :\t"+findGene("GTCATGAAGTATAAGTAA"));
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
    public  static void main(String [] args){
        Part1 o = new Part1();
        //o.testFindStopCodon();
        //o.testFindGene();
        o.printAllGenes("ATGGCTTAAGTAATGATGAAGTAG");//1.ATGGCTTA 2.ATGATGAAGTAG
    }
}
