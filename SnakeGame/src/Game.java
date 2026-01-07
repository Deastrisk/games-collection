import data.SettingsData;
import java.awt.*;
import java.util.Map;
import javax.swing.*;
import pages.Page;
import pages.PageTypes;
import pages.Play;
import pages.Settings;
import pages.TitleScreen;

public class Game extends JFrame {
    private final SettingsData settings = new SettingsData();

    public Map<PageTypes, Page> pages = Map.ofEntries(
        Map.entry(PageTypes.TITLE_SCREEN, new TitleScreen(this)),
        Map.entry(PageTypes.PLAY, new Play(settings)),
        Map.entry(PageTypes.SETTINGS, new Settings(settings))
    );

    public Game() {
        this.setSize(600, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setResizable(false);
        this.setTitle("Amazing app");
        ImageIcon icon = new ImageIcon("src\\resources\\snake-game-logo.jpg");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.darkGray);
        this.setLayout(null);
    }
    
    public void start() {
        pages.get(PageTypes.TITLE_SCREEN).display();
        this.setVisible(true);
    }
}