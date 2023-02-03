public class StaticArray {
    public static void main(String[] args) {
        String[] strings;
        strings = new String[] {
            "First String",
            "Second String",
            "Third String",
            "Fourth String"
        };

        strings[0] = "Replaced first string";
        String state = args[0];

        switch (state) {
            case "normal":
                for (int n = 0; n < strings.length; n++) {
                    System.out.println(strings[n]);
                }
                break;
            case "reverse":
                System.out.println("\nPrinting the array in reverse order: ");
                for (int i = strings.length - 1; i >= 0; i--) {
                    System.out.println(strings[i]);
                }
                break;
            default:
                System.out.println("Function is currently not available. Program will exit...");
                System.exit(0);
        }
    }
}
