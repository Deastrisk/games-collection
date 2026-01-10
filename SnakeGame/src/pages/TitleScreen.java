package pages;

import data.CustomColors;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import resources.font.PixelFont;

public class TitleScreen implements Page, ActionListener {
    JFrame frame;
    
    public TitleScreen(JFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void display() {
        // PAGE LAYOUT
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().setBackground(CustomColors.lightGreen());
        
        // TITLE
        JLabel title = new JLabel("Snake Game");
        title.setForeground(CustomColors.darkGreen());
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.LEFT);
        title.setFont(PixelFont.createFont(67));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.LEFT);
        title.setBorder(BorderFactory.createEmptyBorder(20, 20, 25, 40));
        
        // ADD BORDER (for margin/padding on title)
        Border margin = BorderFactory.createEmptyBorder(0, 20, 10, 70);

        // BUTTONS
        frame.add(Box.createVerticalGlue());
        frame.add(title, BorderLayout.CENTER);
        frame.add(createButton("START", margin));
        frame.add(createButton("SETTINGS", margin));
        frame.add(createButton("CREDITS", margin));
        frame.add(createButton("EXIT", BorderFactory.createEmptyBorder(0, 20, 20, 70)));
        frame.add(Box.createVerticalGlue());
    }

    public JButton createButton(String text, Border border) {
        JButton btn = new JButton(text);
        btn.setFont(PixelFont.PIXEL_FONT);
        btn.setForeground(CustomColors.darkGreen());
        btn.setBackground(new Color(0x0000, true));

        // final Dimension btnSize = new Dimension(200, 40);
        // btn.setPreferredSize(btnSize);
        // btn.setMaximumSize(btnSize);
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setBorder(border);
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
