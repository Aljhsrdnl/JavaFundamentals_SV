public class Counter {
    String name;
    int value = 0;

    //constructor
    public Counter(String name) { 
        this.name = name;
        System.out.println(String.format("Counter %s created", name));
    
    }

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public void report() {
        System.out.println(String.format("Value of %s: %d", name, value ));
    }
}
