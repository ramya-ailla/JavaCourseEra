package Week1;

public class WordPlay {
    boolean isVowel(char ch){
        if(ch == 'A'||ch=='a'||ch=='E'||ch=='e'||ch =='I'||ch =='i'||ch =='O'||ch =='o'||ch =='U'||ch =='u'){
            return true;
        }
        return false;
    }
    String replaceVowels(String phrase,char x){
        StringBuilder s = new StringBuilder(phrase);
        for(int i =0; i<s.length();i++)
        {
            if(isVowel(s.charAt(i))){
                s.setCharAt(i,x);
            }
        }
        return s.toString();
    }
    String emphasize(String phrase,char ch){
        StringBuilder s = new StringBuilder(phrase);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch){
                if(i%2==0){
                    s.setCharAt(i,'*');
                }
                else
                    s.setCharAt(i,'+');
            }
        }
        return s.toString();
    }
    public static void main(String [] args){
        WordPlay o = new WordPlay();
        System.out.println("E : "+o.isVowel('E'));
        System.out.println("e : "+o.isVowel('e'));
        System.out.println("phrase is \'hello world\'\n vowels are replaced with &\n"+o.replaceVowels("hello world",'&'));
        System.out.println("Emphasize result:\n phrase is \'hello world\' \n letter is \' o\'\n"+o.emphasize("hello world",'o'));
    }
}
