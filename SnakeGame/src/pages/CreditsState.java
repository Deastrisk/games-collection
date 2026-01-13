package pages;

public class CreditsState implements Page {
    @Override
    public void enter(PagesContext context) {
        context.showPage(Pages.CREDITS);
    }

    @Override
    public void exit(PagesContext context) {}
}
