package Week1;

import edu.duke.FileResource;
public class CaesarCipher {

    String encrypt(String input,int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabetUpper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = alphabetUpper.toLowerCase();
        String shiftedAlphabetUpper = alphabetUpper.substring(key)+alphabetUpper.substring(0,key);
        String shiftedAlphabetLower = shiftedAlphabetUpper.toLowerCase();

        for(int i=0;i<input.length();i++){
           char currChar = input.charAt(i);
           if(Character.isLowerCase(currChar)){
                encrypted.setCharAt(i,replaceChar(currChar,alphabetLower,shiftedAlphabetLower));
            }
           else if(Character.isUpperCase(input.charAt(i))){
               encrypted.setCharAt(i,replaceChar(currChar,alphabetUpper,shiftedAlphabetUpper));
           }
        }
        return encrypted.toString();
    }
    char replaceChar(char currChar,String alpha,String shiftedAlpha){
        int index = alpha.indexOf(currChar);
        if(index != -1){
            currChar = shiftedAlpha.charAt(index);
        }
        return currChar;
    }
    String encryptTwoKeys(String input,int key1,int key2){
        StringBuilder s = new StringBuilder(input);

        for(int i=0;i<input.length();i++){
            if(i%2==0){
                s.setCharAt(i,encrypt(Character.toString(input.charAt(i)),key1).charAt(0));
            }
            else{
                s.setCharAt(i,encrypt(Character.toString(input.charAt(i)),key2).charAt(0));
            }
        }
        return s.toString();
    }
    void testCaesar(){
        //FileResource fr = new FileResource();
       // String input = fr.asString();
        String input2 = "FIRST LEGION ATTACK EAST FLANK!";
        String input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println("input is "+input2+"\n encrypted as "+encrypt(input2,23));
    }
    public static void main(String [] args){
        CaesarCipher o = new CaesarCipher();
        o.testCaesar();
        //System.out.println(" String is\t At noon be in the conference room with your hat on for a surprise party. YELL LOUD!\n" +
          //      "\n\n key1 = 8,\t key2 = 21\n"+ o.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
    }


}
