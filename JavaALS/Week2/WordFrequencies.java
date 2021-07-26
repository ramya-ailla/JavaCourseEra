package Week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreq;
    WordFrequencies(ArrayList<String> myWords,ArrayList<Integer>myFreq){
        this.myWords=myWords;
        this.myFreq=myFreq;
    }
    void findUnique(){
        myWords.clear();
        myFreq.clear();
        FileResource fr = new FileResource();
        for(String word: fr.words()){
            word = word.toLowerCase();
            int indexOfWord = myWords.indexOf(word);
            if(indexOfWord ==-1){
                myWords.add(word);
                myFreq.add(1);
            }
           else{
                int prevFrq = myFreq.get(indexOfWord);
                int newFreq = prevFrq+1;
                myFreq.set(indexOfWord,newFreq);
           }
        }


    }
    void tester()
    {
        findUnique();
        System.out.println("Number of Unique words "+myWords.size());
        for (int i =0;i<myWords.size();i++){
            System.out.println(myFreq.get(i)+" "+myWords.get(i));
        }
        System.out.println(" The element that occurs most often in the selected file is - " + myWords.get(findIndexOfMax())+" occurs "+myFreq.get(findIndexOfMax())+" times");
    }

    int findIndexOfMax(){
        int maxEleIndex=0;
        for(int i =0;i<myWords.size();i++){
            if(myFreq.get(maxEleIndex)<myFreq.get(i)){
                maxEleIndex = i;
            }
        }
        return  maxEleIndex;
    }
    public static void main(String[] args){
        WordFrequencies o = new WordFrequencies(new ArrayList<String>(),new
                ArrayList<Integer>());
        o.tester();

    }


}
