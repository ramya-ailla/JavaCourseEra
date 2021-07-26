package Week1.CaesarCipherOOPS.TwoKeys;

import edu.duke.FileResource;

public class TestCaesarCipher2 {
    private int[] countLetters(String encrypted) {
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

    private int maxIndex(int[] freqs) {
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

    private String halfOfString(String message, int start) {
        StringBuilder halvedMessage = new StringBuilder();

        for (int i = start; i < message.length(); i+= 2) {
            halvedMessage.append(message.charAt(i));
        }

        return halvedMessage.toString();
    }

    private int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;

        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }

        return dkey;
    }

    private String breakCaesarCipher(String input) {
        String oddString = halfOfString(input, 0);
        String evenString = halfOfString(input, 1);

        int key1 = getKey(oddString);
        int key2 = getKey(evenString);

        CaesarCipher2 cc = new CaesarCipher2(key1, key2);

        return cc.decrypt(input);
    }

    public void simpleTests() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipher2 cc = new CaesarCipher2(17, 3);

        String encrypted = cc.encrypt(message);
        System.out.println("Encryption");
        System.out.println(message + " -> " + encrypted);

        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decryption");
        System.out.println(encrypted + " -> " + decrypted);

        decrypted = breakCaesarCipher(encrypted);
        System.out.println("Break Caesar Cipher");
        System.out.println(encrypted + " -> " + decrypted);
    }

    public static void main(String[] args) {
        TestCaesarCipher2 testCaesarCipherTwo = new TestCaesarCipher2();
        testCaesarCipherTwo.simpleTests();
    }
}
