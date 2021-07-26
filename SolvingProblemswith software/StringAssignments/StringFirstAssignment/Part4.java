import edu.duke.URLResource;
public class Part4 {
    public void findYoutube(){
        URLResource file = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String word : file.words()) {
            String itemLower = word.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if (pos != -1) {
                int beg = word.lastIndexOf("\"",pos);
                int end = word.indexOf("\"",pos+1);
                System.out.println(word.substring(beg+1,end));
            }
        }
    }
    public static void main(String [] args){
        Part4 obj = new Part4();
        obj.findYoutube();
    }
}
