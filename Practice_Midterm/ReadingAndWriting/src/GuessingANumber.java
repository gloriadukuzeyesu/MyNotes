import java.util.Random;
import java.util.Scanner;

public class GuessingANumber {
        public static void main ( String [] args ) {
        int secretNumber;
        int attempt= 0;
        secretNumber = (int) (Math.random() * 100);
        System.out.println("Secret number " + secretNumber);
        Scanner keyBoard = new Scanner(System.in);
        int userInput = 0;
        do {
            System.out.println("Enter a guess number between 1-100: ");
            if ( keyBoard.hasNextInt()) {
                userInput = keyBoard.nextInt();
                if (userInput == secretNumber) {
                    System.out.println("Your guess is right! Congratulation!!");
                    System.exit(0);
                } else if (userInput < secretNumber) {
                    System.out.println("Your guess is smaller than the Secret number ");
                } else if (userInput > secretNumber) {
                    System.out.println("Your guess is greater than the Secret number ");
                }
                attempt++;
                if (attempt == 10) {
                    System.out.println(" You've reached the maximum attempts. Try again later");
                    System.out.println("The secret number was " + secretNumber);
                    System.exit(0);
                }
            }
            else {
                System.out.println("Enter a valid number");
                System.exit(0);
            }
        }
        while (userInput != secretNumber);
    }
}
