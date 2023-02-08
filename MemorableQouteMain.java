import java.util.ArrayList;

public class MemorableQouteMain {
    public static void main(String[] args) {
        MemorableQouteDatabase qouteDB = new MemorableQouteDatabase();
        int sizeQouteDB = qouteDB.getSize();

        if(args.length == 0) {
            System.out.println("No argument provided. You may choose between the following convention: \n[ java MemorableQoute all ]\n[ java MemorableQoute random ]\n[ java MemorableQoute search <search key> ]\n[ java MemorableQoute display ]");
            System.exit(0);
        }
        else if (args.length == 2) {
            String [] splittedArgsTwo = args[1].split("=", 2);
            ArrayList <MemorableQoute> arr = MemorableQouteDatabase.getAllBasedOnCategory(splittedArgsTwo[1]);
            switch(args[0]) {
                case "all":
                    arr.forEach(qoute -> {
                        MemorableQoute.printQoute(qoute.getQoute(), qoute.getCategory());
                    });
                    break;
                case "random": 
                    //get size of arr
                    int arrSize = arr.size();
                    //get randomIndex
                    int randIndex = MemorableQoute.getRandomIndex(arrSize);
                    // print qoute using the index
                    MemorableQoute q = arr.get(randIndex);
                    MemorableQoute.printQoute(q.getQoute(), q.getCategory());
                    break;
            }
        }
        else {
            switch(args[0]) {
                case "all":
                    System.out.println("\nALL QOUTES:");
                    ArrayList <MemorableQoute> newArr = qouteDB.getAllQoutes();
                    newArr.forEach((q) -> {
                        // System.out.println(q.getQoute());
                        MemorableQoute.printQoute(q.getQoute(), q.getPrintCounter());
                    });
                    break;
                case "random":
                    MemorableQoute randomQoute = MemorableQoute.getRandomQuote(sizeQouteDB, qouteDB);
                    String qoute = randomQoute.getQoute();
                    int counter = randomQoute.getPrintCounter();
                    MemorableQoute.printQoute(qoute, counter);
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
                    if(args.length == 1 ) {
                        instanceOne.execute(0, 3);
                    }
                    else if (args.length == 2 ) {
                        String [] splitArgs = args[1].split("=", 2);
                        int delayOrMax = Integer.parseInt(splitArgs[1]);
                        if(splitArgs[0].equalsIgnoreCase("delay")){
                            instanceOne.execute(0, delayOrMax);
                        }
                        else if(splitArgs[0].equalsIgnoreCase("max")){
                            instanceOne.execute(delayOrMax, 3);
                        }
                        else {
                            System.out.println("Sorry, unrecognized parameter.");
                        }
                    }
                    break;
                default:
                    System.out.println("Sorry, that argument is not available as of the moment.");
                    break;
                    
            }   
        }

    }
}
