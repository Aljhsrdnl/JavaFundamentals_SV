public class StringConcatenation {
    public static void main (String[] args) {

       
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i <= 100000; i++) {
            builder.append("x");
        }
        
        // String str = "";
        
        // for (int i = 0; i <= 100000; i++) {
        //     str += 'x';
        // }
        

        System.out.println(builder);
    }
}
