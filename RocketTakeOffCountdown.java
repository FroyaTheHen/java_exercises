import java.util.Scanner;

public class RocketTakeOffCountdown {
    public static void main(String args[]) throws InterruptedException {

        System.out.println(
                "Please, specify how many seconds are left" +
                " until take-off: ");
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        int secUntilTakeOff = input.nextInt();

        System.out.println("Fasten your seatbelts!");

        for (secUntilTakeOff = secUntilTakeOff - 1;
             secUntilTakeOff > 0;
             secUntilTakeOff--) {

            System.out.println(secUntilTakeOff);
            Thread.sleep(1000);
        }
        System.out.println("0! Launching successful! Welcome to space!");

    }
}

