package Week4;

import java.io.File;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slice = new StringBuilder();
        for (int i = whichSlice;i<message.length();i=i+totalSlices){
            char currChar = message.charAt(i);
            slice.append(currChar);
        }
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        for(int sliceNumber =0;sliceNumber<klength;sliceNumber++){
            String slice = sliceString(encrypted,sliceNumber,klength);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            key[sliceNumber] = cc.getKey(slice);
        }
        return key;
    }

    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dictionary = new HashSet<>();
        for(String word: fr.words()){
            String wordTobeAdded = word.toLowerCase();
            dictionary.add(wordTobeAdded);
        }
        return dictionary;
    }
    public int countWords(String message,HashSet<String> dictionary){
        int wordCount =0;
        for(String word:message.split("\\W+")){
            if(dictionary.contains(word.toLowerCase())){
                wordCount++;
            }
        }
        return wordCount;
    }
    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character,Integer> countChar = new HashMap<>();
        int maxOccurrence=0;
        char maxChar ='\0';
        for (String word:dictionary){
            countCharInWord(countChar,word);
        }
        for(char ch:countChar.keySet()){
            int currOccurrence = countChar.get(ch);
            if(currOccurrence>maxOccurrence){
                maxOccurrence=currOccurrence;
                maxChar=ch;
            }
        }
        return maxChar;
    }
    private void countCharInWord(HashMap<Character,Integer> countChar,String word){
        for(int i =0;i<word.length();i++){
            char currChar = word.charAt(i);
            if(countChar.containsKey(currChar)){
                countChar.put(currChar,countChar.get(currChar)+1);
            }
            else{
                countChar.put(currChar,1);
            }
        }
    }
    public String breakForLanguage(String encrypted,HashSet<String> dictionary){
        int curCount=0, maxCount =0;
        String decrypted = "";
        int keyL=0;
        char mostCommonChar = mostCommonCharIn(dictionary);
        for(int keyLength = 1;keyLength<100;keyLength++){
            int[] key = tryKeyLength(encrypted,keyLength,mostCommonChar);

            VigenereCipher vc = new VigenereCipher(key);
            String curDecrypted = vc.decrypt(encrypted);

            curCount = countWords(curDecrypted,dictionary);
            if(curCount>maxCount){
                maxCount=curCount;
                decrypted=curDecrypted;

            }
        }

        return decrypted;
    }
    public String breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages){
        HashSet<String> dictionary;
        int curCount=0,maxCount = 0;
        String decrypted="";
        for(String language:languages.keySet()){
            dictionary= languages.get(language);

            String curDecrypted = breakForLanguage(encrypted,dictionary);

            curCount = countWords(curDecrypted,dictionary);
            if(curCount>maxCount){
                maxCount = curCount;
                decrypted = curDecrypted;
            }
        }
        return decrypted;
    }
    public void breakVigenere () {
        FileResource fr = new FileResource();
        String message = fr.asString();

        HashMap<String,HashSet<String>> languages= new HashMap<>();
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fd = new FileResource(f);
            HashSet<String> dictionary = readDictionary(fd);
            String lang = f.getName();
            languages.put(lang,dictionary);
        }

        String decrypted = breakForAllLangs(message,languages);
        System.out.println(decrypted);

    }
}
