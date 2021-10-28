import java.util.Scanner;

public class FibonacciNumber {
    private static int getFibonacciNumber(int n) {
        int n1 = 0;
        int n2 = 1;

        if (n == 1)
            return 1;

        for (int i = 1; i < n; i++) {
            n2 += n1;
            n1 = n2 - n1;
            }
        return n2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "Value of which index from the Fibonacci " +
                "sequence do you want to calculate: "
                );
        int n = input.nextInt();

        int value = getFibonacciNumber(n);
        System.out.println(
                "The value of Fibonacci number with index: "
                        + n + " is: " + value);
    }
}
