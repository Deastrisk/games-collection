import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

import resources.CustomColors;
import pages.PagesContext;

public class PlayPanel extends JPanel {
    private static final ImageIcon heartFilled;
    private static final ImageIcon heartEmpty;

    static {
        int HEART_HEIGHT = 18;
        int HEART_WIDTH = 18;

        ImageIcon unscaledHeartFilled = new ImageIcon("src/resources/minecraft-heart-filled.png");
        Image scaledHeartFilled = unscaledHeartFilled.getImage().getScaledInstance(HEART_WIDTH, HEART_HEIGHT, Image.SCALE_SMOOTH);
        heartFilled = new ImageIcon(scaledHeartFilled);

        ImageIcon unscaledHeartEmpty = new ImageIcon("src/resources/minecraft-heart-empty.png");
        Image scaledHeartEmpty = unscaledHeartEmpty.getImage().getScaledInstance(HEART_WIDTH, HEART_HEIGHT, Image.SCALE_SMOOTH);
        heartEmpty = new ImageIcon(scaledHeartEmpty);
    }

    public PlayPanel(PagesContext context) {
        this.setBackground(CustomColors.lightGreen());
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel gameContainer = new JPanel();
        gameContainer.setBackground(CustomColors.darkGreen());
        gameContainer.setLayout(new BorderLayout());
        gameContainer.setBackground(Color.BLACK);
        gameContainer.setOpaque(false);
        // gameContainer.setSize(new Dimension(300, 500));
        // gameContainer.setMinimumSize(new Dimension(300, 500));

        JPanel hearts = new JPanel();
        hearts.setOpaque(false);
        hearts.add(createHeart());
        hearts.add(createHeart());
        hearts.add(createHeart());

        JPanel score = new JPanel();
        score.setOpaque(false);
        // score.add(createApple());

        gameContainer.add(hearts, BorderLayout.NORTH);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;

        this.add(gameContainer, gbc);
    }

    private JLabel createHeart() {
        if (heartFilled.getIconWidth() == -1) {
            System.err.println("Couldn't find file: src/resources/minecraft-heart-filled.png");
            return null;
        }
        return new JLabel(heartFilled);
    }
}
