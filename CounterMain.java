public class CounterMain {
    public static void main(String[] args) {
        Counter counter1 = new Counter("c1");
        Counter counter2 = new Counter("c2");

        counter1.increment();
        counter1.increment();
        counter1.increment();
        counter1.increment();
        counter1.increment();
        counter1.increment();
        counter1.increment();
        counter1.increment();
        // counter2.increment();
        counter1.report();
        counter2.report();
    }
}
