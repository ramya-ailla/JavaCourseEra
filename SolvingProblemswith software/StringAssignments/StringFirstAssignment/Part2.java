public class Part2 {

    static String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String result = " ";
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {
            return result;
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        if (stopIndex == -1) {
            return result;
        }
        if ((stopIndex - startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex + 3);
        }
        return result;
    }

    public static void main(String[] args) {
        String testdna1 = "TATGTGATAGGATTAAT";
        String testdna2 = "ATTTAGTAA";
        String testdna3 = "ATGTGGAAT";
        String testdna4 = "ATGGGGTTTTTTAA";
        String testdna5 = "ATTGGAAA";
        //valid gene : it should start with ATG and end with TAA and gene's length should be multiple of 3

        //dna 1
        System.out.println("dna is " + testdna1);
        System.out.println("gene is " + findSimpleGene(testdna1, "ATG", "TAA"));

        System.out.println("dna is " + testdna1.toLowerCase());
        System.out.println("gene is " + findSimpleGene(testdna1.toLowerCase(), "atg", "taa"));

        //dna 2

        System.out.println("dna is " + testdna2);
        System.out.println("gene is " + findSimpleGene(testdna2, "ATG", "TAA"));

        System.out.println("dna is " + testdna2.toLowerCase());
        System.out.println("gene is " + findSimpleGene(testdna2.toLowerCase(), "atg", "taa"));

        //dna 3

        System.out.println("dna is " + testdna3);
        System.out.println("gene is " + findSimpleGene(testdna3, "ATG", "TAA"));

        System.out.println("dna is " + testdna3.toLowerCase());
        System.out.println("gene is " + findSimpleGene(testdna3.toLowerCase(), "atg", "taa"));

        // dna 4

        System.out.println("dna is " + testdna4);
        System.out.println("gene is " + findSimpleGene(testdna4, "ATG", "TAA"));

        System.out.println("dna is " + testdna4.toLowerCase());
        System.out.println("gene is " + findSimpleGene(testdna4.toLowerCase(), "atg", "taa"));

        //dna 5
        System.out.println("dna is " + testdna5);
        System.out.println("gene is " + findSimpleGene(testdna5, "ATG", "TAA"));

        System.out.println("dna is " + testdna5.toLowerCase());
        System.out.println("gene is " + findSimpleGene(testdna5.toLowerCase(), "atg", "taa"));


    }
}
