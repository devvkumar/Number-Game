import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 7;
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            rounds++;
            int secretNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;
            int userGuess;

            System.out.println("\n--- Round " + rounds + " ---");
            System.out.println("Guess the number between " + lowerRange + " and " + upperRange + "!");

            while (attempts < maxAttempts) {
                attempts++;

                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number (" + secretNumber + ") in " + attempts + " attempts!");
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.nextLine().equalsIgnoreCase("yes"));

        System.out.println("\nTotal Rounds: " + rounds);
        System.out.println("Total Attempts: " + totalAttempts);
        double averageAttempts = (double) totalAttempts / rounds;
        System.out.printf("Average Attempts per Round: %.2f", averageAttempts);

        scanner.close();
    }
}
