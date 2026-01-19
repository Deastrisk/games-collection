package main;

import javax.swing.JFrame;

public class Game extends JFrame {
    public Game() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Treasure Hunter");
        
        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);

        this.pack();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.startGameThread();
    }
}
