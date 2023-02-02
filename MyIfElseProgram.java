public class MyIfElseProgram {
    public static void main (String[] args) {
        int n;
        for (n = 0; n < 20; n++) {
            if (n == 0) {
                System.out.println(String.format("First one: %d", n));
            }
            else if (n < 5) {
                System.out.println(String.format("Less than five: %d", n));
            }
            else if (n == 10 || n == 11) {
                System.out.println("Ten or Eleven: " + n);
            }
            else if (n >= 13 && n <= 18) {
                System.out.println("YEHEY!");
            }
            else {
                System.out.println(String.format("NOT less than five: %d", n));
            }
        }
    }
}
