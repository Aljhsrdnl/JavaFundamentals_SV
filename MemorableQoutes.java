import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import javax.sound.sampled.SourceDataLine;

import java.util.regex.Matcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class MemorableQoutes {
    static void createQoutes(ArrayList<String> quotes) {
        quotes.add("Opportunities don't happen, you create them.@Guru199@motivational");
        quotes.add("It is never too late to be what you might have been.@idk123@motivational");
        quotes.add("\"All our dreams can come true, if we have the courage to pursue them.\"@Walt Disney@motivational");
        quotes.add("\"Only the paranoid survive.\"@Andy Grove@motivational");
        quotes.add("\"We need to accept that we won\'t always make the right decisions, that we'll screw up royally sometimes―understanding that failure is not the opposite of success, it's part of success.\"@Arianna Huffington@motivational");
        quotes.add("Do what you can, with what you have, where you are.@Theodore Roosevelt@motivational");
        quotes.add("Nothing succeeds like success. Get a little success, and then just get a little more.@Maya Angelou@motivational");
        quotes.add("I like the dreams of the future better than the history of the past.@Thomas Jefferson@motivational");
        quotes.add("Logic will get you from A to B. Imagination will take you everywhere.@Albert Einstein@motivational");
        quotes.add("What do you call a sleeping bull? A bulldozer.@NoAuthor@joke");
        quotes.add("Why did the photo go to jail? It was framed.@NoAuthor@joke");
        quotes.add("Where do polar bears keep their money? In a snowbank.@NoAuthor@joke");
    }

    static ArrayList<String> readFile(String fileName){
        ArrayList <String> qoutes = new ArrayList<String>();
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                qoutes.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return qoutes;
    }
    static String getRandomQuote() {
        ArrayList <String> quotes = readFile("qoutes.txt");
        Random random = new Random();
        int index = random.nextInt(quotes.size()); 
        return quotes.get(index);
    }
    static ArrayList<String> getJokes (ArrayList<String> quotes) {
        ArrayList <String> jokes = new ArrayList<String>();
        for(int i = 0; i < quotes.size(); i++) {
            String [] currentQuote = quotes.get(i).split("@", 4);
            if(currentQuote[2].equalsIgnoreCase("joke")) {
                jokes.add(quotes.get(i));
            }
    }
        return jokes;
    }

    static ArrayList<String> getMotivational (ArrayList<String> quotes) {
        ArrayList <String> motivational = new ArrayList <String> ();

        for(int i = 0; i < quotes.size(); i++) {
            String [] currentQuote = quotes.get(i).split("@", 4);
            if(currentQuote[2].equalsIgnoreCase("motivational")) {
                motivational.add(quotes.get(i));
            }
        }
        return motivational;
    }
    
    static void printAllQuote(ArrayList<String> quotes) {
        for(int i = 0; i < quotes.size(); i++) {
            printQuote(quotes.get(i)); 
        }
    }

    static void printQuote(String quote) {
        String[] splittedQuote = quote.split("@", 4);
        incrementCounter(quote);
        System.out.println(String.format("%s \n-- %s \nNumber of Times Displayed: %s\n", splittedQuote[0], splittedQuote[1], splittedQuote[3]));
    }

    static void printQuoteWithNum(String quote, int index, int total) { 
        String[] splittedQuote = quote.split("@", 4);

        //pass the parameter splittedQoute[0]
        //update function
        incrementCounter(quote);
        //to update the counter in the text file
        System.out.println(String.format("[%d/%d]  %s \n\t-- %s \nNumber of Times Displayed: %s", index, total, splittedQuote[0], splittedQuote[1], splittedQuote[3]));
    }

    static void incrementCounter(String qouteBody){
        ArrayList <String> qoutes = readFile("qoutes.txt");

        //loop and compare
        int size = qoutes.size();
        for(int i = 0; i < size; i++) {
            String[] qouteSplitted = qoutes.get(i).split("@",4);
            String[] qouteBodySplitted = qouteBody.split("@", 4);
            
            if(qouteSplitted[0].equals(qouteBodySplitted[0])) {
                int counter = Integer.parseInt(qouteBodySplitted[3]);
                counter++;
                qouteBodySplitted[3] = String.valueOf(counter); //int to string
                String str = String.format("%s@%s@%s@%s", qouteBodySplitted[0], qouteBodySplitted[1], qouteBodySplitted[2], qouteBodySplitted[3]);
                qoutes.set(i, str);
            }
        }
        try {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter("qoutes.txt"));
            qoutes.forEach((q) -> {
                try {
                    fWriter.write(q);
                    fWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    

    static void searchQuote(ArrayList<String> quotes, String keyword) {
        for(int i = 0; i < quotes.size(); i++) {
            Pattern pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(quotes.get(i));
            boolean matchFound = matcher.find();

            if(matchFound == true) {
                printQuote(quotes.get(i));
            }
        }
    }
    static void display(ArrayList<String> quotes) {
        while(true) {
            String randomQuote = getRandomQuote();
            printQuote(randomQuote);
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    static void addQoute(String qoute, String author, String category) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("qoutes.txt", true));
            String str = String.format("\n%s@%s@%s@0", qoute, author, category);
            writer.write(str);
            writer.close();
            System.out.println(String.format("Qoute '%s' has been added.", qoute));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteQoute(String key) {
        ArrayList <String> qoutes = readFile("qoutes.txt");

        for(int i = 0; i < qoutes.size(); i++) {
            Pattern pattern = Pattern.compile(key, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(qoutes.get(i));
            // boolean matchFound = matcher.find();

            if(matcher.find()) {
                qoutes.remove(i);
            }
        }

        //write to file
        try {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter("qoutes.txt"));
            qoutes.forEach((q) -> {
                try {
                    fWriter.write(q);
                    fWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void displayCategory(ArrayList <String> category) {
        int max = 5;
        int delay = 2000;
        for (int i = 0; i < max; i++) {
            String randomQuote = getRandomQuote();
            printQuoteWithNum(randomQuote, i+1, max);
            try {
                Thread.sleep(delay);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    static void newDisplay(ArrayList <String> quotes, int max, int delay){
        int ms = delay * 2000;
        for (int i = 0; i < max; i++) {
            String randomQuote = getRandomQuote();
            printQuoteWithNum(randomQuote, i+1, max);
            try {
                Thread.sleep(ms);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public static void main(String[] args) {
        ArrayList <String> quotes = new ArrayList<String> ();
        
        // createQoutes(quotes);
        quotes = readFile("qoutes.txt");
        //check the args' length
        if(args.length == 0) {
            System.out.println("NO ARGUMENT FOUND. Please include an argument. Choose between: \n[random]\n[all]\n[search]");
            System.exit(0);
        }
        else if(args[0].equalsIgnoreCase("random")) {
            String randomQuote = getRandomQuote();
            printQuote(randomQuote);
        }
        else if(args[0].equalsIgnoreCase("all")) {
            printAllQuote(quotes);
        }
        else if(args[0].equalsIgnoreCase("search")) {
            searchQuote(quotes, args[1]);
        }
        else if (args[0].equalsIgnoreCase("addQoute")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Provide the following information: \n");
            System.out.print("Qoute: ");
            String qoute = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Category: ");
            String category = sc.nextLine();

            addQoute(qoute, author, category);
        }
        else if (args[0].startsWith("category")) {
            //check if parameter is correct;
            //split
            String[] args1 = args[0].split("=", 2);
            if(args1.length != 2) {
                System.out.println();System.out.println("Sorry, you provided incomplete parameters. Please follow the following convention: \n\n[java MemorableQoutes category=jokes]\n");
                System.exit(0);
            }
            //check if args is jokes or motivational
            if(args1[1].equals("jokes")){
                ArrayList <String> jokes = getJokes(quotes);
                // print infintely but all jokes only
                displayCategory(jokes);
            }
            if(args1[1].equals("motivational")){
                ArrayList <String> motivational = getMotivational(quotes);
                // print infintely but all motivational only
                displayCategory(motivational);
            }
        }
        else if(args[0].equalsIgnoreCase("display")) {
            if(args.length == 3 ) { //complete args were supplied
                //get the parameters
                //identify which parameters is delay and max
                String args1 = args[1];
                String args2 = args[2];

                //split args using regex
                String [] args1Splitted = args1.split("=", -1); //length should be two
                String [] args2Splitted = args2.split("=", -1);
                
                //what if hindi max or delay ang input?
                if(!(args1Splitted[0].equals("delay")) && !(args1Splitted[0].equals("max"))) {
                    System.out.println("The first parameter is unrecognizable. You may choose to provide either or all of the two parameters. e.g [max=1 delay=1]");
                    System.exit(0);
                }
                if(!(args2Splitted[0].equals("delay")) && !(args2Splitted[0].equals("max"))) {
                    System.out.println("The second parameter is unrecognizable. You may choose to provide either or all of the two parameters. e.g [max=1 delay=1]");
                    System.exit(0);
                }

                int max;
                int delay;
                
                //check length of args1 and args2
                if(args1Splitted.length <= 1 || args2Splitted.length <= 1) {
                    System.out.println("Sorry, you provided incomplete parameters. Please follow the following convention: \n\n[java MemorableQoutes max=2 delay=2]\n");
                    System.exit(0);
                } 

                if(args1Splitted[0].equalsIgnoreCase("delay") && args2Splitted[0].equalsIgnoreCase("max")) {
                    try {
                        delay = Integer.parseInt(args1Splitted[1]);
                        max = Integer.parseInt(args2Splitted[1]);
                        newDisplay(quotes, max, delay);
                    }
                    catch(NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                if(args1Splitted[0].equalsIgnoreCase("max") && args2Splitted[0].equalsIgnoreCase("delay")) {
                    try {
                        max = Integer.parseInt(args1Splitted[1]);
                        delay = Integer.parseInt(args2Splitted[1]);
                        newDisplay(quotes, max, delay);
                    }
                    catch(NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            if(args.length == 2) {
                String args1 = args[1];
                //split
                String [] args1Splitted = args1.split("=", -1);
                //check if length == 2
                if(args1Splitted.length < 2) {
                    System.out.println("Sorry, you provided incomplete parameters. Please follow the following convention: \n\n[java MemorableQoutes max=2 delay=2]\n");
                    System.exit(0);
                }

                //check if args is delay or max
                if(!(args1Splitted[0].equals("delay")) && !(args1Splitted[0].equals("max"))) {
                    System.out.println("The parameter is unrecognizable. You may choose to provide either or all of the two parameters. e.g [max=1 delay=1]");
                    System.exit(0);
                }
                int delay;
                int max;
                if(args1Splitted[0].equalsIgnoreCase("delay")) {
                    try {
                        delay = Integer.parseInt(args1Splitted[1]);
                        max = 10; //default
                        newDisplay(quotes, max, delay);
                    }
                    catch(NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                if(args1Splitted[0].equalsIgnoreCase("max")) {
                    try {
                        delay = 3 ; //default
                        max = Integer.parseInt(args1Splitted[1]); 
                        newDisplay(quotes, max, delay);
                    }
                    catch(NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

            }
            if(args.length == 1) {
                display(quotes);
            }
        }
        else {
            System.out.println(String.format("Sorry, %d is not a feature of this program. :'(", args[0]));
        }
    }
}
