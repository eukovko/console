import java.util.Optional;
import java.util.Scanner;

public class WelcomeMenu implements Menu {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public Class<? extends Menu> read() {
        System.out.println("""
                Menu:
                1. Guess the number
                0. Quit
                """);
        Optional<Integer> option = readOption();
        if (option.isEmpty()) {
            return IncorrectOptionMenu.class;
        } else {
            return switch (option.get()) {
                case 0 -> QuitMenu.class;
                case 1 -> GuessTheNumberMenu.class;
                default -> null;
            };
        }
    }

    private Optional<Integer> readOption() {
        String input = scanner.nextLine();
        try {
            int option = Integer.parseInt(input);
            if (option < 0 || option > 1)
                return Optional.empty();
            else
                return Optional.of(option);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
