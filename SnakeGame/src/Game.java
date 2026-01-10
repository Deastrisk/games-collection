import data.SettingsData;
import java.awt.*;
import javax.swing.*;
import pages.PagesContext;

public class Game extends JFrame {
    private final SettingsData settings = new SettingsData();

    public Game() {
        // frame size
        Dimension minimumSize = new Dimension(1000, 550);
        this.setSize(minimumSize);
        this.setMinimumSize(minimumSize);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Amazing app");

        // window icon
        ImageIcon icon = new ImageIcon("src\\resources\\snake-game-logo.jpg");
        this.setIconImage(icon.getImage());

        // default bg color
        this.getContentPane().setBackground(Color.darkGray);
        this.setLayout(new CardLayout());
    }
    
    public void start() {
        PagesContext pageContext = new PagesContext(this);
        for (int i = 0; i < 5; i++) {
            pageContext.request();
        }
    }
}