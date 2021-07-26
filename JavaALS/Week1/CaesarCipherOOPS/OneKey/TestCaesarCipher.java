package Week1.CaesarCipherOOPS.OneKey;

import edu.duke.FileResource;

public class TestCaesarCipher {
    public int[] countLetters(String encrypted) {
        int[] counts = new int[26];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < encrypted.length(); i++) {
            int index = alphabet.indexOf(Character.toLowerCase(encrypted.charAt(i)));

            if (index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }

    public int maxIndex(int[] freqs) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] > max) {
                max = freqs[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    private String breakCaesarCipher(String encrypted){
        int [] freq = countLetters(encrypted);
        int maxIndex = maxIndex(freq);
        int dkey = maxIndex - 4;
        if(maxIndex <4){
            dkey = 26 -(4-maxIndex);
        }
        CaesarCipher o = new CaesarCipher(dkey);
        return o.decrypt(encrypted);
    }
    void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);

        String encrypted = cc.encrypt(message);
        System.out.println("Encryption:");
        System.out.println(message + " -> " + encrypted);

        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decryption:");
        System.out.println(encrypted + " -> " + decrypted);

        decrypted = breakCaesarCipher(encrypted);
        System.out.println("Break Caesar Cipher");
        System.out.println(encrypted + " -> " + decrypted);
    }

    public static void main(String[] args) {
        TestCaesarCipher o = new TestCaesarCipher();
        o.simpleTests();
    }

}
