package pages;

import java.awt.*;
import javax.swing.*;

import resources.CustomColors;
import pages.PagesContext;

import pages.KeyHandler;
import data.PlayModel;
import data.SettingsData;

public final class PlayPanel extends JPanel {
    static final ImageIcon heartFilled;
    static final ImageIcon heartEmpty;

    final KeyHandler keyH;
    final SettingsData settings;

    final PlayModel playModel;

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
        // adds controls
        this.playModel = context.getPlayModel();
        this.settings = context.getSettings();
        this.keyH = context.getKeyHandler();
        this.addKeyListener(keyH);

        // GUI shi
        this.setBackground(CustomColors.lightGreen());
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.setLayout(new GridBagLayout());
        this.setDoubleBuffered(true);

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

        JPanel board = new JPanel();
        board.setLayout(new GridLayout(
            playModel.GAME_WIDTH, playModel.GAME_HEIGHT, playModel.GAME_GAP, playModel.GAME_GAP
        ));

        gameContainer.add(hearts, BorderLayout.NORTH);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;

        this.add(gameContainer, gbc);
    }

    // private void fillBoard(JPanel board) {
    //     for (int i = 0; i < GAME_HEIGHT; i++) {
    //         for (int j = 0; j < GAME_WIDTH; j++) {
    //             // board.add(createCell(BOARD[i][j]));
    //         }
    //     }
    // }

    // private JPanel createCell(int )

    public bindModel(PlayModel model) {
        
    }

    private JLabel createHeart() {
        if (heartFilled.getIconWidth() == -1) {
            System.err.println("Couldn't find file: src/resources/minecraft-heart-filled.png");
            return null;
        }
        return new JLabel(heartFilled);
    }

    // public void startGameThread() {
    //     gameThread = new Thread(this);
    //     gameThread.start();
    // }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillOval(playModel.playerHeadX, playerHeadY, tileSize, tileSize);
        g2.dispose();
    }
}
