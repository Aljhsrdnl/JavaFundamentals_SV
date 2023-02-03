public class Multidimensional {
    public static void main(String[] args) {
        int [][] array = new int [10][5];
        int c = 0;
        for(int n1 = 0; n1 < 10; n1++) {
            for(int n2 = 0; n2 < 5; n2++) {
                array[n1][n2] = c++;
            }
        }
        //printing
        for(int n1 = 0; n1 < 10; n1++) {
            for(int n2 = 0; n2 < 5; n2++) {
                System.out.print(String.format("%d, ", array[n1][n2]));
            }
            System.out.println();
        }
    }   
}

//Multidimensional Array
//String.format() method