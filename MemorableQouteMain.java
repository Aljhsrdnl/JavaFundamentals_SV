import java.util.ArrayList;

public class MemorableQouteMain {
    public static void main(String[] args) {
        MemorableQouteDatabase qouteDB = new MemorableQouteDatabase();
        int sizeQouteDB = qouteDB.getSize();

        if(args.length == 0) {
            System.out.println("No argument provided. You may choose between the following convention: \n[ java MemorableQoute all ]\n[ java MemorableQoute random ]\n[ java MemorableQoute search <search key> ]\n[ java MemorableQoute display ]");
            System.exit(0);
        }
        else {
            switch(args[0]) {
                case "all":
                    System.out.println("\nALL QOUTES:");
                    ArrayList <MemorableQoute> newArr = qouteDB.getAllQoutes();
                    newArr.forEach((q) -> {
                        System.out.println(q.getQoute());
                    });
                    break;
                case "random":
                    MemorableQoute randomQoute = MemorableQoute.getRandomQuote(sizeQouteDB, qouteDB);
                    String qoute = randomQoute.getQoute();
                    String reference = randomQoute.getReference();
                    MemorableQoute.printQoute(qoute, reference);
                    break;
                case "search":
                    // text param has been provided
                    if(args.length == 2) {
                        ArrayList <MemorableQoute> matchedArr = MemorableQouteDatabase.searchQoutes(args[1]);
                        //display all matches
                        if(matchedArr.size() == 0) {
                            System.out.println(String.format("Sorry, no match found for the keyword %s.", args[1]));
                        }
                        else {
                            matchedArr.forEach((match) -> {
                                MemorableQoute.printQoute(match.getQoute(), match.getReference());
                            });
                        }
                    }
                    else {
                        System.out.println("Invalid parameters");
                    }
                    break;
                case "display":
                    MemorableQoutesDisplayShow instanceOne = new MemorableQoutesDisplayShow(qouteDB);
                    instanceOne.execute(0, 2);
                    break;
                default:
                    System.out.println("Sorry, that argument is not available as of the moment.");
                    break;
                    
            }   
        }

    }
}
