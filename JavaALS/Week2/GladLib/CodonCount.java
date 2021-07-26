package Week2.GladLib;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String,Integer> codonCount;
    public CodonCount(HashMap<String,Integer> dnaCodon){
        codonCount = dnaCodon;
    }
    void buildCodonMap(int start,String dna){
        String codon ="";
        codonCount.clear();
        for(int i =start;i<dna.length();i++){
            codon=codon+dna.charAt(i);
            if(codon.length()==3){
                if(codonCount.keySet().contains(codon)){
                    codonCount.replace(codon,codonCount.get(codon)+1);
                }
                else{
                    codonCount.put(codon,1);
                }
                codon="";
            }
        }
    }
    String getMostCommonCodon(){
        int freq =0;
        String mostCommonCodon="";
        for(String codon:codonCount.keySet()){
            if(freq<codonCount.get(codon)){
                freq =codonCount.get(codon);
                mostCommonCodon = codon;
            }
        }
        return mostCommonCodon;
    }
    void printCodonCount(int start,int end){
        for(String codon:codonCount.keySet()){
            int freq = codonCount.get(codon);
            if(freq>=start && freq<=end){
                System.out.println(codon + " - "+freq);
            }
        }
    }

    public static void main(String[] args) {
        CodonCount o = new CodonCount(new HashMap<String,Integer>());
        o.buildCodonMap(2,"CGTTCAAGTTCAA");
        o.printCodonCount(1,5);
        o.getMostCommonCodon();
    }
}
