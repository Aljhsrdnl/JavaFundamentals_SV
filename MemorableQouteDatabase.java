import java.util.ArrayList;

public class MemorableQouteDatabase {
    public static ArrayList <MemorableQoute> qoutes; //declaration
    public MemorableQouteDatabase(){
        qoutes = new ArrayList<MemorableQoute>();
        MemorableQoute m1 = new MemorableQoute("Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle. - Christian D. Larson", "Christian");   
        MemorableQoute m2 = new MemorableQoute("Don't watch the clock; do what it does. Keep going. - Sam Levenson", "Sam");   
        MemorableQoute m3 = new MemorableQoute("Success is not final, failure is not fatal: it is the courage to continue that counts. - Winston Churchill", "Winston");   
        MemorableQoute m4 = new MemorableQoute("The only limit to our realization of tomorrow will be our doubts of today. - Franklin D. Roosevelt", "Franklin");   
        //add qoutes
        qoutes.add(m1);
        qoutes.add(m2);
        qoutes.add(m3);
        qoutes.add(m4);
    }   

    public  int getSize() {
        return qoutes.size();
    }

    public MemorableQoute getQoute(int index) {
        return qoutes.get(index);
    }

    public void addQoute(MemorableQoute qoute) {
        qoutes.add(qoute);
        System.out.println("Successfully added qoute");
    }

    public int getQouteCount() {
        return getSize();
    }

    public MemorableQoute getQouteByIndex(int n) {
        MemorableQoute qoute = qoutes.get(n);
        return qoute;
    }

    public ArrayList <MemorableQoute> getAllQoutes() {
        return qoutes;
    }

    public void removeQoute(MemorableQoute qoute) {
        //search the qoute by matching the "qoute" parameters
        String searchParam = qoute.getQoute();
        int indexToBeRemoved=0;
        int size = qoutes.size();
        
        for (int i = 0; i < size; i++) {
            MemorableQoute currentQoute = qoutes.get(i);
            if(currentQoute.getQoute().equalsIgnoreCase(searchParam)){
                indexToBeRemoved = i;
            }
            }
        qoutes.remove(indexToBeRemoved);
        System.out.println("Successfully deleted qoute.");
    }

    public static ArrayList<MemorableQoute> searchQoutes(String text) {
        ArrayList <MemorableQoute> matchedQoutesArray = new ArrayList<MemorableQoute>();

        qoutes.forEach((qoute) -> {
            if(MemorableQoute.matches(qoute, text)){
                matchedQoutesArray.add(qoute);
            }
        });

        return matchedQoutesArray;
    }


}

