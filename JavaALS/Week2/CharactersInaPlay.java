package Week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInaPlay {
    private ArrayList<String> myCharacters;
    private ArrayList<Integer> myFreq;

    CharactersInaPlay(ArrayList<String> myCharacters,ArrayList<Integer> myFreq){
        this.myCharacters = myCharacters;
        this.myFreq= myFreq;
    }

    void update(String name){
        int indexOfChar =myCharacters.indexOf(name);
        if(indexOfChar==-1){
            myCharacters.add(name);
            myFreq.add(1);
        }
        else{
            int freq = myFreq.get(indexOfChar);
            int newFreq = freq+1;
            myFreq.set(indexOfChar,newFreq);
        }
    }

    void findAllCharacters(){
        FileResource fr = new FileResource();
        myCharacters.clear();
        myFreq.clear();
        for(String line : fr.lines()){
            if(line.contains(".")){
                update(line.substring(0,line.indexOf(".")));
            }
        }
    }

    void tester(){
        findAllCharacters();
        for(int i =0;i<myCharacters.size();i++){
            System.out.println(myFreq.get(i)+" "+myCharacters.get(i));
        }
        charactersWithNumParts(3,3);

    }
    void charactersWithNumParts(int num1,int num2){
        for(int i =0;i<myFreq.size();i++){
            if(myFreq.get(i)>=num1 && myFreq.get(i)<=num2){
                System.out.println(myCharacters.get(i));
            }
        }
    }

    public static void main(String[] args) {
        CharactersInaPlay o = new CharactersInaPlay(new ArrayList<String>(),new ArrayList<Integer>());
        o.tester();
    }
}
