import java.util.Scanner;

public class Factorial {
    private static long getFactorial(int n) {
        long factorial = 1;
        for (int i=1; i < n; i++) {
            factorial = factorial * (i+1);
        }
        return factorial;
    }

    public static void main(String args[]){
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        // Get number form a user
        System.out.println("What number you want to calculate a factorial for? " );
        int n = input.nextInt();
        // Calculate factorial
        long factorial = getFactorial(n);
        System.out.println(n + "!=" + factorial);
    }

}

