package pages;

import data.CustomColors;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TitleScreen implements Page, ActionListener {
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
        titlePanel.setBackground(Color.GREEN);
        titlePanel.setBounds(0, 0, 600, 80);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.MAGENTA);
        buttonsPanel.setBounds(0, 80, 300, 370);

        JPanel snakeGIFPanel = new JPanel();
        snakeGIFPanel.setBackground(Color.BLUE);
        snakeGIFPanel.setBounds(300, 80, 300, 370);

        // TITLE
        JLabel title = new JLabel("Snake Game");
        title.setForeground(Color.white);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 50));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        
        titlePanel.add(title);

        // BUTTONS
        JButton startBtn = new JButton("START");
        startBtn.setFont(new Font("SansSerif", Font.PLAIN, 20));
        startBtn.setForeground(Color.white);
        startBtn.setBackground(CustomColors.redishBrown());
        startBtn.setBorder(BorderFactory.createLineBorder(CustomColors.darkGreen(), 2, true));

        JButton settingsBtn = new JButton("SETTINGS");
        settingsBtn.setFont(new Font("SansSerif", Font.PLAIN, 20));
        settingsBtn.setForeground(Color.white);
        settingsBtn.setBackground(CustomColors.redishBrown());

        JButton exitBtn = new JButton("EXIT");
        exitBtn.setFont(new Font("SansSerif", Font.PLAIN, 20));
        exitBtn.setForeground(Color.white);
        exitBtn.setBackground(CustomColors.redishBrown());
        
        buttonsPanel.add(startBtn);
        buttonsPanel.add(settingsBtn);
        buttonsPanel.add(exitBtn);

        // adds panels to frame
        frame.add(titlePanel);
        frame.add(buttonsPanel);
        frame.add(snakeGIFPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == startBtn) {

        // }
    }
}
