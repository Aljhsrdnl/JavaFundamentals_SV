import java.util.ArrayList;

public class SimpleProductDatabase {
    public static void main(String[] args) {
        ArrayList <String> products = new ArrayList<String>();

        //insert strings
        products.add("Hawk Bag:2500");
        products.add("Jansport:3500");
        products.add("Cose:1200");
        products.add("Samsonite:2000");

        for(int n = 0; n < products.size(); n++) {
            String curProd = products.get(n);
            String [] splittedProd = curProd.split(":", 2);
            System.out.println(String.format("Product: %s, Price: Php %s", splittedProd[0], splittedProd[1]));
        }
    }
}

//used split() method
//ArrayList
