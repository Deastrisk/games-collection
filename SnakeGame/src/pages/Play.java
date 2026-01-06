package pages;

import data.SettingsData;

public class Play implements Page {
    private final SettingsData settings;

    public Play(SettingsData settings) {
        this.settings = settings;
    }

    @Override
    public void display() {
        // System.out.println("h")
    }
}
