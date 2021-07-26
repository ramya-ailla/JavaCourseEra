package Week4;

import edu.duke.FileResource;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        //CaesarCipher o = new CaesarCipher(4);
        /*FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println("Message is ");
        System.out.println(message);*/

       /* int [] keys = {17,14,12,4};
        VigenereCipher o = new VigenereCipher(keys);
        String encrypted = o.encrypt(message);
        System.out.println("Encrypted as ");
        System.out.println(encrypted);*/

        VigenereBreaker o = new VigenereBreaker();
        /*FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println(Arrays.toString(o.tryKeyLength(message,4,'e')));*/
         o.breakVigenere();



    }
}
