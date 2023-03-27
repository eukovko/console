import java.util.HashMap;
import java.util.Map;

public class MainMenu {

    public static final int NUMBER_OF_ATTEMPTS = 5;
    private Menu currentMenu;
    private final Map<Class<? extends Menu>, Menu> menuMap = new HashMap<>();

    public MainMenu() {
        menuMap.put(WelcomeMenu.class, new WelcomeMenu());
        menuMap.put(QuitMenu.class, new QuitMenu());
        menuMap.put(IncorrectOptionMenu.class, new IncorrectOptionMenu());
        menuMap.put(GuessTheNumberMenu.class, new GuessTheNumberMenu(NUMBER_OF_ATTEMPTS));
        menuMap.put(YouLostMenu.class, new YouLostMenu());
        menuMap.put(YouWonMenu.class, new YouWonMenu());
        this.currentMenu = menuMap.get(WelcomeMenu.class);
    }

    public void run() {
        while (currentMenu != null)
            currentMenu = menuMap.get(currentMenu.read());
    }
}
