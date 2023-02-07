import java.util.Random;

public class MemorableQoute {
    String qouteText;
    String reference;

    public MemorableQoute(String qoute, String reference) {
        this.qouteText = qoute;
        this.reference = reference;
    }
    
    // method for qoute variable
    public void setQoute(String qoute) {
        this.qouteText = qoute;
    }
    
    public String getQoute() {
        return this.qouteText;
    }

    //methods for reference variable
    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return this.reference;
    }

    public static int getRandomIndex(int size) {
        Random rand = new Random();
        int index = rand.nextInt(size);
        return index;
    }

    public static MemorableQoute getRandomQuote(int size, MemorableQouteDatabase qoutes) {
        int index = getRandomIndex(size);
        return  qoutes.getQoute(index);
    }

    public static void displayQoute(String qoute) {
        System.out.println(qoute);
    }

    //method overloading
    public static void printQoute(String qoute) {
        System.out.println(qoute);
    }

    public static void printQoute(String qoute, String reference) {
        System.out.println(String.format("%s \n-- <%s>", qoute, reference));
    }

    public static  boolean matches(MemorableQoute qoute, String text) {
        boolean isMatched = false;
        String qt = qoute.getQoute().toLowerCase();
        String reference = qoute.getReference().toLowerCase();
        text = text.toLowerCase();

        if(qt.contains(text) || reference.contains(text)) {
            isMatched = true;
        }

        return isMatched;
    }

    public static void main(String[] args) {
        MemorableQouteDatabase qouteDB = new MemorableQouteDatabase();
        int sizeQouteDB = qouteDB.getSize();
        if(args.length == 0) {
            System.out.println("No argument provided. You may choose between the following convention: \n[ java MemorableQoute all ]\n[ java MemorableQoute random ]\n[ java MemorableQoute search <search key> ]");
            System.exit(0);
        }
        
        MemorableQoute randomQoute = getRandomQuote(sizeQouteDB, qouteDB);
        String qoute = randomQoute.getQoute();
        String reference = randomQoute.getReference();
        printQoute(qoute, reference);
    }
}
