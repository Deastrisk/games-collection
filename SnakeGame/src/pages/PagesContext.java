package pages;

import java.awt.CardLayout;
import java.awt.Container;

public class PagesContext {
    private Page currentPage;
    private final CardLayout card;
    private final Container container;

    // private SettingsData settingsData;

    public PagesContext(Container container, CardLayout card) {
        this.card = card;
        this.container = container;
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
}
