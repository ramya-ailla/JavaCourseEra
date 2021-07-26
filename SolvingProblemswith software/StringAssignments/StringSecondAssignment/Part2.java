public class Part2 {
    int howMany(String stringA,String stringB){
        int count = 0;
        int curIndex = stringB.indexOf(stringA);
        while(curIndex != -1){
            count++;
            curIndex = stringB.indexOf(stringA,curIndex+stringA.length());
        }
        return count;
    }
    void testHowMany(){
        System.out.println(howMany("na","banana"));
        System.out.println(howMany("a","alphabet"));
        System.out.println(howMany("ti","repetition"));
    }
    public static void main(String [] args){
        Part2 p = new Part2();
        p.testHowMany();
    }
}
