package pages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import data.SettingsData;

public class PagesContext {
    private Page currentPage;
    private SettingsData settingsData;
    
    protected JPanel titleScreenPanel;
    protected JPanel settingsPanel;
    protected JPanel creditsPanel;
    protected JPanel playPanel;

    public PagesContext(JFrame frame) {
        currentPage = new TitleScreen();
        this.settingsData = new SettingsData();
        
        titleScreenPanel = new JPanel();
        settingsPanel = new JPanel();
        creditsPanel = new JPanel();
        playPanel = new JPanel();

        frame.add(settingsPanel);
        frame.add(creditsPanel);
        frame.add(playPanel);
        frame.add(titleScreenPanel);
    }

    public void setPage(Page page) {
        if (page == null) {
            return;
        }
        currentPage = page;
    }

    public void request() {
        currentPage.handle(this);
    }
}
