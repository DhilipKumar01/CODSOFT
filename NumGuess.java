 import java.util.Random;
import java.util.Scanner;

public class NumGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int attempts = 0;
        int maxAttempts = 10; // You can set a limit for attempts
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int userGuess = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Guess a number between " + min + " and " + max + ":");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    hasGuessedCorrectly = true;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've used all attempts. The number was: " + numberToGuess);
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
            attempts = 0; // Reset attempts for the next round
        }

        scanner.close();
        System.out.println("Thank you for playing!");
    }
}
