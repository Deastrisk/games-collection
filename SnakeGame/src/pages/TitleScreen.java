package pages;

import data.CustomColors;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import resources.font.PixelFont;

public class TitleScreen implements Page {
    JButton startBtn;
    JButton settingsBtn;
    JButton creditsBtn;
    JButton exitBtn;

    private PageTypes nextPage;
    
    public TitleScreen() {
        this.nextPage = PageTypes.INVALID;
    }
    
    @Override
    public void display(JPanel panel) {
        // PAGE LAYOUT
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(CustomColors.lightGreen());
        
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
        startBtn = createButton("START", margin);
        startBtn.addActionListener(e -> switchToPlay());

        settingsBtn = createButton("SETTINGS", margin);
        settingsBtn.addActionListener(e -> switchToSettings());

        creditsBtn = createButton("CREDITS", margin);
        creditsBtn.addActionListener(e -> switchToCredits());

        exitBtn = createButton("EXIT", BorderFactory.createEmptyBorder(0, 20, 20, 70));
        exitBtn.addActionListener(e -> switchToExit());

        panel.add(Box.createVerticalGlue());
        panel.add(title, BorderLayout.CENTER);
        panel.add(startBtn);
        panel.add(settingsBtn);
        panel.add(creditsBtn);
        panel.add(exitBtn);
        panel.add(Box.createVerticalGlue());

        panel.setVisible(true);
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

    private void switchToPlay() { nextPage = PageTypes.PLAY; }
    private void switchToSettings() { nextPage = PageTypes.SETTINGS; }
    private void switchToCredits() { nextPage = PageTypes.CREDITS; }
    private void switchToExit() { nextPage = PageTypes.EXIT; }

    public Page handleButtonPress() {
        return switch (nextPage) {
            case PageTypes.PLAY: yield new Play();
            case PageTypes.SETTINGS: yield new Settings();
            case PageTypes.CREDITS: yield new Play();
            case PageTypes.EXIT: System.exit(0);
            default: yield null;
        };
    }

    @Override
    public void handle(PagesContext context) {
        this.display(context.titleScreenPanel);
        context.setPage(handleButtonPress());
    }
}
