package pages;

import java.awt.*;
import javax.swing.*;

public class TitleScreen implements Page {
    JFrame frame;
    public TitleScreen(JFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void display() {
        frame.setLayout(null);

        // PAGE LAYOUT
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.DARK_GRAY);
        // titlePanel.setForeground(new Color(0, true));
        // titlePanel.setOpaque(true);
        titlePanel.setBounds(0, 0, 600, 50);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());
        buttonsPanel.setBackground(Color.MAGENTA);
        buttonsPanel.setBounds(0, 50, 300, 400);

        JPanel snakeGIFPanel = new JPanel();
        snakeGIFPanel.setBackground(Color.BLUE);
        snakeGIFPanel.setBounds(300, 50, 300, 400);

        // TITLE
        JLabel title = new JLabel("Snake Game");
        title.setForeground(new Color(0xFFFFFF));
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 20));
        // title.setBackground(new Color(200, 150, 200, 0));
        // title.setOpaque(true);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);

        titlePanel.add(title);

        frame.add(titlePanel);
        frame.add(buttonsPanel);
        frame.add(snakeGIFPanel);
    }
}
