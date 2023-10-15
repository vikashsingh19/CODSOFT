import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private final int minRange;
    private final int maxRange;
    private final int maxAttempts;
    private int totalAttempts;
    private int roundsWon;
    private int roundsPlayed;
    private final Random random;
    private final Scanner scanner;

    public NumberGuessingGame(int minRange, int maxRange, int maxAttempts) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.maxAttempts = maxAttempts;
        this.totalAttempts = 0;
        this.roundsWon = 0;
        this.roundsPlayed = 0;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        while (roundsPlayed < 5) { // Play 5 rounds.
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            System.out.println("Welcome to Round " + (roundsPlayed + 1) + " of the Number Guessing Game!");
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                totalAttempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempt + " attempts.");
                    roundsWon++;
                    break;
                }

                if (attempt == maxAttempts) {
                    System.out.println("You've reached the maximum number of attempts. The correct number was " + randomNumber);
                }
            }

            roundsPlayed++;

            if (roundsPlayed < 5) {
                System.out.print("Do you want to go to the next round or quit? (y/n): ");
                String playChoice = scanner.next();
                if (playChoice.equalsIgnoreCase("n")) {
                    break; // The player loses if they quit.
                }
            }
        }

        if (roundsWon >= 3) {
            System.out.println("Congratulations! You won the game.");
        } else {
            System.out.println("Sorry, you lost the game.");
        }

        System.out.println("Thanks for playing!");
        System.out.println("Your score: Rounds won: " + roundsWon + ", Total attempts: " + totalAttempts);
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame(1, 100, 5); // 5 attempts per round
        game.play();
    }
}
