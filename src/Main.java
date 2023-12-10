import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String PLAY_AGAIN_MESSAGE = """
            Play again?
            1 - Yes
            2 - No
            """;

    private static void showHelp(final int guess, final int secretNumber) {
        if (guess < secretNumber) {
            System.out.println("Your guess was too low!");
        } else {
            System.out.println("Your guess was too high!");
        }
        System.out.println("Try again...");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int option = 1;

        while (option == 1) {

            final int secretNumber = new Random().nextInt(101);

            System.out.println("Can you guess a number between 0 and 100? You have only 5 tries.");

            for (int i = 0; i < 5; i++) {

                final int guess = scanner.nextInt();

                if (guess == secretNumber) {
                    System.out.println("Well done! You nailed it");
                    break;

                } else if (i == 4) {
                    System.out.println("Too bad, you didn't guess the number!");
                    System.out.println("The secret number was " + secretNumber);
                } else {
                    showHelp(guess, secretNumber);
                }
            }
            System.out.println(PLAY_AGAIN_MESSAGE);
            option = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Thank you for playing");
    }

}