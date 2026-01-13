package pages;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import resources.CustomColors;
import resources.font.PixelFont;

public class CreditsPanel extends JPanel {
    public CreditsPanel(PagesContext context) {
        this.setBackground(CustomColors.darkGreen());
        this.setLayout(new BorderLayout());

        JLabel title = new JLabel("Credits");
        title.setFont(PixelFont.createFont(50));
        title.setForeground(CustomColors.lightGreen());
        this.add(title, BorderLayout.NORTH);
    }
}
