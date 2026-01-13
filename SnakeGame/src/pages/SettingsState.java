package pages;

public class SettingsState implements Page {
    @Override
    public void enter(PagesContext context) {
        context.showPage(Pages.SETTINGS);
    }

    @Override
    public void exit(PagesContext context) {}
}
