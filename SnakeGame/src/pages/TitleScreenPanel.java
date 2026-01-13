package pages;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import resources.CustomColors;
import resources.font.PixelFont;

public class TitleScreenPanel extends JPanel {
    public TitleScreenPanel(PagesContext context) {
        // PAGE LAYOUT
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(CustomColors.lightGreen());
        
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
        JButton startBtn = createButton("START", margin);
        startBtn.addActionListener(e -> {
            context.setPage(new PlayState());
        });

        JButton settingsBtn = createButton("SETTINGS", margin);
        settingsBtn.addActionListener(e -> {
            context.setPage(new SettingsState());
        });

        JButton creditsBtn = createButton("CREDITS", margin);
        creditsBtn.addActionListener(e -> {
            // context.setPage(new );
        });

        JButton exitBtn = createButton("EXIT", BorderFactory.createEmptyBorder(0, 20, 20, 70));
        exitBtn.addActionListener(e -> {
            System.exit(0);
        });

        this.add(Box.createVerticalGlue());
        this.add(title, BorderLayout.CENTER);
        this.add(startBtn);
        this.add(settingsBtn);
        this.add(creditsBtn);
        this.add(exitBtn);
        this.add(Box.createVerticalGlue());
    }

    private JButton createButton(String text, Border border) {
        JButton btn = new JButton(text);
        btn.setFont(PixelFont.PIXEL_FONT);
        btn.setForeground(CustomColors.darkGreen());
        btn.setBackground(new Color(0x0000, true));

        // positioning the button and margin
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setBorder(border);
        btn.setBorderPainted(false);

        btn.setFocusable(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);
        btn.setFocusPainted(false);

        return btn;
    }
}
