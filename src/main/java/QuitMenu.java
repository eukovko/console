public class QuitMenu implements Menu {

    QuitMenu() {}
    @Override
    public Class<? extends Menu> read() {
        System.out.println("Bye!!!");
        return null;
    }
}
