package pages;

public class PlayState implements Page {
    @Override
    public void enter(PagesContext context) {
        context.showPage(Pages.PLAY);
    }

    @Override
    public void exit(PagesContext context) {}
}
