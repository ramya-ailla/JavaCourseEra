public class Part2 {
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
    int countCTG(String dna){
        int count = 0;
        dna = dna.toLowerCase();
        int ctgIndex = dna.indexOf("ctg");
        while(ctgIndex != -1){
            count++;
            ctgIndex = dna.indexOf("ctg",ctgIndex+3);
        }
        return count;
    }
    public static void main(String [] args){
        Part2 p = new Part2();
        //System.out.println(p.cgRatio("ATGCCATAG"));
        System.out.println(p.countCTG("ATTCTGATCTGCTG"));//3
    }
}
