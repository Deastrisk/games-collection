package pages;

import data.SettingsData;

public class Settings implements Page {
    private final SettingsData settings;

    public Settings(SettingsData settings) {
        this.settings = settings;
    }

    @Override
    public void display() {

    }

    // @Override
    // public void handleRequest(PagesContext context) {
    //     display();
    //     context.setPage(new TitleScreen(null));
    // }
}
