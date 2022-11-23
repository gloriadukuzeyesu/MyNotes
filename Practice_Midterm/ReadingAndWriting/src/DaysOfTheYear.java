import java.nio.file.attribute.UserPrincipal;
import java.util.Scanner;

public class DaysOfTheYear {
    /*public static void main(String[] args) {
        // declare variables to store days

        int daysOfTheWeek = 7;
        Scanner keyboard = new Scanner(System.in);

        int userInput;
        boolean validNumber = true;

            System.out.println(" Enter day of the year between 1-365: ");
            if (keyboard.hasNextInt()) {
                userInput = keyboard.nextInt();
                validNumber = true;

                if (userInput % daysOfTheWeek == 1) {
                    System.out.println(" The entered day is Monday ");
                } else if (userInput % daysOfTheWeek == 2) {
                    System.out.println(" The day is Tuesday ");
                } else if (userInput % daysOfTheWeek == 3) {
                    System.out.println(" The day is Wednesday ");
                } else if (userInput % daysOfTheWeek == 4) {
                    System.out.println(" The day is Thursday ");
                } else if (userInput % daysOfTheWeek == 5) {
                    System.out.println(" The day is Friday ");
                } else if (userInput % daysOfTheWeek == 6) {
                    System.out.println(" The day is Saturday ");
                } else if (userInput % daysOfTheWeek == 0) {
                    System.out.println(" The day is Sunday");
                }
            } else {
                System.out.println("Invalid number. Try again");

            }
                        keyboard.close();



    }*/

    public static void main( String [] args ) {
        Scanner sc = new Scanner(System.in);
        int day = -1;
        while ( day < 1 || day > 365 ) {
            System.out.println("Enter a day of the year between 1-365: ");
            day = sc.nextInt();
        }
        String[] daysArray = { "Sunday", "Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println( "The day is " + daysArray[day % 7]);
    }
}

