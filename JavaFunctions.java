public class JavaFunctions {
    // function returning a float value of a number divided by two
    static float myFunction(float x) { 
        return x/2;
    }
    public static void main (String[] args) {
        //loop through 30 float numbers and use the function to generate answers
        for (float x = 0; x < 30; x++) {
            System.out.println(String.format("f(%f) = %f", x, myFunction(x)));
        }
    }
}