public class Part1 {
    static String findSimpleGene(String dna){
        String result = " ";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return result;
        }
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if(stopIndex == -1){
            return result;
        }
        if((stopIndex - startIndex) % 3 == 0){
            result = dna.substring(startIndex,stopIndex+3);
        }
        return result;
    }
    //valid gene : it should start with ATG and end with TAA and gene's length should be multiple of 3
    public static void main(String [] args){
        String testdna1 ="ATGTGATAGGATTAA";
        String testdna2 = "ATTTAGTAA";
        String testdna3 = "ATGTGGAAT";
        String testdna4 = "ATGGGGTTTTTTAA";
        String testdna5 = "ATTGGAAA";

        System.out.println("dna is " + testdna1);
        System.out.println("gene is "+findSimpleGene(testdna1));

        System.out.println("dna is " + testdna2);
        System.out.println("gene is "+findSimpleGene(testdna2));

        System.out.println("dna is " + testdna3);
        System.out.println("gene is "+findSimpleGene(testdna3));

        System.out.println("dna is " + testdna4);
        System.out.println("gene is "+findSimpleGene(testdna4));

        System.out.println("dna is " + testdna5);
        System.out.println("gene is "+findSimpleGene(testdna5));

    }

}
