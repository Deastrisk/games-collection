package pages;

public class TitleScreenState implements Page {
    @Override
    public void enter(PagesContext context) {
        context.showPage(Pages.TITLE_SCREEN);
    }

    @Override
    public void exit(PagesContext context) {}
}
