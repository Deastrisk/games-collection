import java.awt.*;
import javax.swing.*;
import java.util.Map;

public class Game extends JFrame {
    private final SettingsData settings = new SettingsData();

    public Map<PageTypes, Page> pages = Map.ofEntries(
        Map.entry(PageTypes.TITLE_SCREEN, TitleScreen()),
        Map.entry(PageTypes.PLAY, Play(settings)),
        Map.entry(PageTypes.SETTINGS, Settings(settings))
    );

    public Game() {
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setResizable(false);
        this.setTitle("Amazing app");
        ImageIcon icon = new ImageIcon("src\\assets\\snake-logo.png");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.darkGray);

        this.setVisible(true);
    }

    public void start() {
        JLabel title = new JLabel("Snake Game");
        title.setForeground(Color.white);
        title.setIcon(new ImageIcon("src\\assets\\snake-logo.png"));
        title.setVerticalTextPosition(JLabel.TOP);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 20));
        title.setIconTextGap(-5);
        title.setBackground(Color.blue);
        title.setOpaque(true);

        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);

        this.add(title);

    }
}

}
