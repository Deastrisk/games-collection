package pages;

import data.CustomColors;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import resources.font.PixelFont;

public class TitleScreen implements Page, ActionListener {
    JFrame frame;
    
    public TitleScreen(JFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void display() {
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(CustomColors.lightGreen());

        // PAGE LAYOUT
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new Dimension(100, 150));

        JPanel contentsPanel = new JPanel();
        contentsPanel.setLayout(new GridLayout());
        contentsPanel.setOpaque(false);
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setPreferredSize(new Dimension(1000, 100));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        JPanel snakeGIFPanel = new JPanel();
        snakeGIFPanel.setOpaque(false);
        snakeGIFPanel.setPreferredSize(new Dimension(1000, 100));

        // adds panels to frame
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(contentsPanel, BorderLayout.CENTER);
        contentsPanel.add(buttonsPanel);
        contentsPanel.add(snakeGIFPanel);

        // TITLE
        JLabel title = new JLabel("Snake Game");
        title.setForeground(CustomColors.darkGreen());
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setFont(PixelFont.createFont(67));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        
        titlePanel.add(title, BorderLayout.CENTER);

        // BUTTONS
        buttonsPanel.add(Box.createVerticalGlue());
        buttonsPanel.add(createButton("START"));
        buttonsPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(createButton("SETTINGS"));
        buttonsPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(createButton("CREDITS"));
        buttonsPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(createButton("EXIT"));
        buttonsPanel.add(Box.createVerticalGlue());
    }

    public JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(PixelFont.PIXEL_FONT);
        btn.setForeground(CustomColors.darkGreen());
        btn.setBackground(new Color(0x0000, true));

        final Dimension btnSize = new Dimension(200, 40);
        btn.setPreferredSize(btnSize);
        btn.setMaximumSize(btnSize);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn.setBorder(BorderFactory.createLineBorder(new Color(0x000000), 0));
        btn.setBorderPainted(false);

        btn.setFocusable(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);
        btn.setFocusPainted(false);

        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == startBtn) {

        // }
    }

    // @Override
    // public void handleRequest(PagesContext context) {
    //     this.display();
    // }
}
