import data.SettingsData;
import java.awt.*;
import javax.swing.*;
import pages.*;

public class Game extends JFrame {
    private final SettingsData settings = new SettingsData();
    private final CardLayout card;
    private final Container container;

    public Game() {
        // frame size
        Dimension minimumSize = new Dimension(1000, 550);
        this.setSize(minimumSize);
        this.setMinimumSize(minimumSize);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Amazing app");

        // window icon
        ImageIcon icon = new ImageIcon("src\\resources\\snake-game-logo.jpg");
        this.setIconImage(icon.getImage());

        // default bg color
        this.getContentPane().setBackground(Color.darkGray);

        card = new CardLayout();
        container = getContentPane();
        container.setLayout(card);
    }
    
    public void start() {
        PagesContext context = new PagesContext(container, card);

        container.add(new TitleScreenPanel(context), Pages.TITLE_SCREEN.name());
        container.add(new SettingsPanel(context), Pages.SETTINGS.name());
        container.add(new CreditsPanel(context), Pages.CREDITS.name());

        context.setPage(new CreditsState());
        this.setVisible(true);
    }
}