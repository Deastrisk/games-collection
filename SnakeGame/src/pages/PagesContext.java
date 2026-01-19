package pages;

import data.PlayModel;
import data.SettingsData;
import java.awt.CardLayout;
import java.awt.Container;

public class PagesContext {
    private Page currentPage;
    private final CardLayout card;
    private final Container container;

    private final SettingsData settingsData;
    private final KeyHandler keyH;
    private final PlayModel playModel;
    private final PlayLoop playLoop;

    public PagesContext(Container container, CardLayout card, PlayPanel playPanel) {
        this.card = card;
        this.container = container;

        settingsData = new SettingsData();
        keyH = new KeyHandler(settingsData);
        playModel = new PlayModel(this);
        playLoop = new PlayLoop(this);
    }

    protected void showPage(Pages name) { 
        card.show(container, name.name()); 
    }

    public void setPage(Page page) {
        if (currentPage != null) {
            currentPage.exit(this);
        }
        currentPage = page;
        currentPage.enter(this);
    }

    public SettingsData getSettings() { return settingsData; }
    public KeyHandler getKeyHandler() { return keyH; }
    public PlayModel getPlayModel() { return playModel; }
    public PlayLoop getPlayLoop() { return playLoop; }
    public PlayPanel getPlayPanel() { return playPanel; }
}
