package pages;

public class Settings implements Page {
    public Settings() {
    }

    @Override
    public void display() {

    }

    @Override
    public void handle(PagesContext context) {
        display();
        context.setPage(new TitleScreen(null));
    }
}
