import java.util.ArrayList;
import java.util.Random;

public class MemorableQoute {
    String qouteText;

    public MemorableQoute(String qoute) {
        this.qouteText = qoute;
    }
    
    public void setQoute(String qoute) {
        this.qouteText = qoute;
    }
    
    public String getQoute() {
        return this.qouteText;
    }

    public int getRandomIndex(int size) {
        Random rand = new Random();
        int index = rand.nextInt(size);
        return index;
    }

    public String getRandomQuote(int index, ArrayList<MemorableQoute> qoutes) {
        MemorableQoute q = qoutes.get(index);
        return q.getQoute();
    }

    public static void main(String[] args) {
        ArrayList <MemorableQoute> qoutesList = new ArrayList <MemorableQoute>();
        
        MemorableQoute m1 = new MemorableQoute("The greatest glory in living lies not in never falling, but in rising every time we fall. -Nelson Mandela");
        MemorableQoute m2 = new MemorableQoute("The way to get started is to quit talking and begin doing. -Walt Disney");
        MemorableQoute m3 = new MemorableQoute("If life were predictable it would cease to be life, and be without flavor. -Eleanor Roosevelt");
        qoutesList.add(m1);
        qoutesList.add(m2);
        qoutesList.add(m3);

        //print a random qoute
        int index = getRandomIndex();
        getRandomQuote
    }
}
