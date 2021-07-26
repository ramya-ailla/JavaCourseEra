package Week1.CaesarCipherOOPS.OneKey;

public class CaesarCipher {
    private String alphabet ;
    private int key;
    private String shiftedAlphabet;

    public CaesarCipher(int key){
        this.key = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        }
    String encrypt(String input){
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            int index = alphabet.toLowerCase().indexOf(Character.toLowerCase(currentCharacter));

            if (index != -1) {
                if (Character.isLowerCase(currentCharacter)) {
                    encrypted.append(Character.toLowerCase(shiftedAlphabet.charAt(index)));
                } else {
                    encrypted.append(shiftedAlphabet.charAt(index));
                }
            } else {
                encrypted.append(currentCharacter);
            }
        }
        return  encrypted.toString();
    }
    String decrypt(String input){
        CaesarCipher c = new CaesarCipher(26-key);
        return c.encrypt(input);
    }
}
