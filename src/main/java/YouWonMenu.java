public class YouWonMenu implements Menu {
    @Override
    public Class<? extends Menu> read() {
        System.out.println("You guessed the number!");
        return WelcomeMenu.class;
    }
}
