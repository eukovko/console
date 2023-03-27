public class YouLostMenu implements Menu {
    @Override
    public Class<? extends Menu> read() {
        System.out.println("You lost");
        return WelcomeMenu.class;
    }
}
