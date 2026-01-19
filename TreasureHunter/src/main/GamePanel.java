package main;

import java.awt.*;
import javax.swing.*;
import entity.Player;

public class GamePanel extends JPanel implements Runnable {

    // Screen settings
    final int originalTileSize = 16; // 16 x 16
    final double scale;
    public final int tileSize;

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth;
    final int screenHeight;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);

    final int FPS = 60;

    public GamePanel() {
        // gets screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        double fullScreenWidth = screenSize.getWidth();
        double fullScreenHeight = screenSize.getHeight();

        // gets the largest possible window with scale still being an int
        scale = Math.floor(Math.min(
            fullScreenHeight / (maxScreenRow * originalTileSize), 
            fullScreenWidth  / (maxScreenCol * originalTileSize)
        ));
        tileSize = originalTileSize * (int) scale;
        screenWidth = maxScreenCol * tileSize;    
        screenHeight = maxScreenRow * tileSize;

        // creates game panel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    public boolean gameIsRunning() {
        return (gameThread != null);
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS; // 1 sec in nanoseconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // runs while game is running, not paused, etc.
        while (gameIsRunning()) {
            // sets FPS
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            // runs only on the specified FPS
            if (delta >= 1) {
                // update game information
                update();
    
                // repaint the updated information on the JPanel
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics graphics) {
        
        // paints the graphic onto the JPanel class (parent of GamePanel).
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D) graphics;
        
        player.draw(g);

        g.dispose();
    }
}