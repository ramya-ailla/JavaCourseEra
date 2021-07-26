package Week1;

import edu.duke.FileResource;

public class WordLengths {
    void countWordLengths(FileResource fr,int[] counts){
        for(String word:fr.words()){
            int countLength = word.length();
            if(!Character.isLetter(word.charAt(0))){
                countLength--;
            }
            if(!Character.isLetter(word.charAt(word.length() - 1))){
                countLength--;
            }
            counts[countLength]++;
        }
    }
    void testCountWordLengths(){
        int []counts = new int[31];
        countWordLengths(new FileResource(),counts);
        for(int i =0;i<31;i++){
            System.out.println("words of length "+i+" - "+counts[i]);
        }
    }

    public static void main(String[] args) {
        WordLengths o = new WordLengths();
        o.testCountWordLengths();
    }
}
