public class Part3 {
    Boolean twoOccurrences(String stringA, String stringB){
        /*returns true if there are atleast two occurances of stringA in stringB */
        String s1= stringA.toLowerCase();
        String s2= stringB.toLowerCase();
        int firstIndex=s2.indexOf(s1);
        if(firstIndex == -1){
            return false;
        }
        else{
            int secondIndex=s2.indexOf(s1,firstIndex+s1.length());
            if(secondIndex == -1){
                return false;
            }
            else{
                return true;
            }
        }
    }
    void testing(){
        //testing twoOccurrences method
        System.out.println("Testing twoOccurrences method");
        System.out.println("string1 : by    string2: A story by Abby Long \n  at least two occurances of stringA in stringB?\n" + twoOccurrences("by","A story by abbby Long"));
        System.out.println("string1 : a    string2: Banana \n at least two occurrences of stringA in stringB?\n" + twoOccurrences("a","Banana"));
        System.out.println("string1 : atg    string2: ctgtatgta \n at least two occurrences of stringA in stringB?\n" + twoOccurrences("atg","ctgtatgta"));

        //testing lastPart method
        System.out.println("Testing lastPart method");
        System.out.println("string1 : zoo    string2: Forest \n" + lastPart("Zoo","Forest"));
        System.out.println("string1 : an    string2: Banana \n" + lastPart("an","Banana"));


    }

    String lastPart(String stringA,String stringB){
        /*returns part of stringA after occurrence of stringB if stringB is found in stringA. else it returns stringB*/
        String s1= stringA.toLowerCase();
        String s2= stringB.toLowerCase();
        int index=s2.indexOf(s1);
        if (index==-1){
            return stringB;
        }
        else{
            return stringB.substring(index+s1.length());
        }
    }
    public static  void main(String [] args){
       Part3 o= new Part3();
       o.testing();
    }
}
