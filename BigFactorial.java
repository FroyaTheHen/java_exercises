import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigInteger;

public class BigFactorial {

    private static BigInteger getFactorial(int n) {
        BigInteger factorial = new BigInteger("1");
        for (int i=1; i < n; i++) {
            String x = String.valueOf(i+1);
            BigInteger y = new BigInteger(x);
            factorial = factorial.multiply(y);
        }
        return factorial;
    }

    public static void main(String args[]){
         // Create a Scanner object
        Scanner input = new Scanner(System.in);
        // Get number form a user
        System.out.println("Enter a natural number to calculate factorial for it: " );
        try {
            int n = input.nextInt();
            // make sure the number is positive
            if (n < 0){
                System.out.println("The number must be positive.");
                return;
            }
            // Calculate factorial
            BigInteger factorial = getFactorial(n);
            System.out.println(n + "!=" + factorial);

        } catch (InputMismatchException e) {
            System.out.println("Given number is incorrect!");
        }
    }
}
