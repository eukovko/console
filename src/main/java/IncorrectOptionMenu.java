public class IncorrectOptionMenu implements Menu {
    @Override
    public Class<? extends Menu> read() {
        System.out.println("You entered an incorrect option");
        return WelcomeMenu.class;
    }
}
