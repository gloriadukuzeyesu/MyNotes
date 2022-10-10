import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalPoints = 0;
        int totalCredits = 0;

        boolean moreClasses = false;

        do {


            int credits = 0;
            boolean ValidCredits;

            do {
                ValidCredits = true;
                System.out.println("Enter number of your credits: ");
                String creditsString = scanner.nextLine();

                try {
                    credits = Integer.parseInt(creditsString);
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a valid integer ");
                    ValidCredits = false;
                }
            }
            while (!ValidCredits);
            boolean validGrade;
            int gradeValue = 0;
            String grade = " "; // never null
            do {
                validGrade = true;
                System.out.println("Enter your grade: ");
                grade = scanner.nextLine();
                if (grade.equalsIgnoreCase("A")) {
                    gradeValue = 4;
                } else if (grade.equalsIgnoreCase("B")) {
                    gradeValue = 3;
                } else if (grade.equalsIgnoreCase("C")) {
                    gradeValue = 2;
                } else if (grade.equalsIgnoreCase("D")) {
                    gradeValue = 1;
                } else if (grade.equalsIgnoreCase("F")) {
                    gradeValue = 0;
                } else {
                    System.out.println("You didn't enter a valid grade :( ");
                    validGrade = false;
                }
            }
            while (!validGrade);
            int points = gradeValue * credits;

            totalPoints += points;
            totalCredits += credits;

            System.out.println("Would do you like to enter another class? (Y/N)");
            String WantMoreClasses = scanner.nextLine();
            moreClasses = WantMoreClasses.equalsIgnoreCase("Y");
        }
        while (moreClasses);

        DecimalFormat df = new DecimalFormat("0.00"); // helper class to round to two decimal places

        Double gpa = (double) totalPoints / (double) totalCredits;

        System.out.println("credits: " + totalCredits);
        System.out.println("Points: " + totalPoints);
        System.out.println("gpa: " + df.format(gpa));

        scanner.close();

    }
}