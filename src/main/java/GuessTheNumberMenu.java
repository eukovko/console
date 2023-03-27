import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberMenu implements Menu {

    private static final Random RANDOM = new Random();
    private int numberOfAttempts;
    private int initialNumberOfAttempts;
    private int numberToGuess = RANDOM.nextInt(10);
    private static Scanner scanner = new Scanner(System.in);

    public GuessTheNumberMenu(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
        this.initialNumberOfAttempts = numberOfAttempts;
    }

    @Override
    public Class<? extends Menu> read() {
        System.out.println("Guess the number between 0 and 10");
        Optional<Integer> number = readNumber();
        if (number.isEmpty()) {
            System.out.println("Invalid input");
            return GuessTheNumberMenu.class;
        } else {
            if (number.get() == numberToGuess) {
                return YouWonMenu.class;
            } else {
                if (numberOfAttempts == 1) {
                    resetNumberOfAttemts();
                    return YouLostMenu.class;
                } else {
                    System.out.println("You didn't guess the number");
                    System.out.format("%d attempts left%n", --numberOfAttempts);
                    return GuessTheNumberMenu.class;
                }
            }
        }
    }

    private void resetNumberOfAttemts() {
        numberOfAttempts = initialNumberOfAttempts;
    }


    private Optional<Integer> readNumber() {
        String input = scanner.nextLine();
        try {
            int option = Integer.parseInt(input);
            if (option < 0 || option > 10)
                return Optional.empty();
            else
                return Optional.of(option);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
