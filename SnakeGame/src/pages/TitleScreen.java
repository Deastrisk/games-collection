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
        frame.setLayout(new BorderLayout());
        frame.setBackground(CustomColors.darkGreen());

        // PAGE LAYOUT
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(CustomColors.darkGreen());
        titlePanel.setPreferredSize(new Dimension(100, 200));

        JPanel contentsPanel = new JPanel();
        contentsPanel.setLayout(new GridLayout());
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.MAGENTA);
        buttonsPanel.setPreferredSize(new Dimension(1000, 100));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        JPanel snakeGIFPanel = new JPanel();
        snakeGIFPanel.setBackground(Color.BLUE);
        snakeGIFPanel.setPreferredSize(new Dimension(1000, 100));

        // adds panels to frame
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(contentsPanel, BorderLayout.CENTER);
        contentsPanel.add(buttonsPanel);
        contentsPanel.add(snakeGIFPanel);

        // TITLE
        JLabel title = new JLabel();
        title.setForeground(Color.white);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        // title.setFont(new Font("SansSerif", Font.BOLD, 50));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);

        Image titleImg = (new ImageIcon("src\\resources\\game-title.png")).getImage();
        ImageIcon titleIcon = new ImageIcon(titleImg.getScaledInstance(400, 300, Image.SCALE_SMOOTH));
        title.setIcon(titleIcon);
        
        titlePanel.add(title);

        // BUTTONS
        // buttonsPanel.add(Box.createVerticalGlue());
        buttonsPanel.add(createButton("START"));
        buttonsPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(createButton("SETTINGS"));
        buttonsPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(createButton("EXIT"));
        // buttonsPanel.add(Box.createVerticalGlue());
    }

    public JButton createButton(String imgPath) {
        JButton btn = new JButton();
        btn.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btn.setForeground(Color.white);
        btn.setBackground(CustomColors.redishBrown());

        ImageIcon img = new ImageIcon(imgPath);

        final Dimension btnSize = new Dimension(140, 35);
        btn.setPreferredSize(btnSize);
        btn.setMaximumSize(btnSize);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setFocusable(false);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == startBtn) {

        // }
    }
}
