package pages;

import java.awt.*;
import javax.swing.*;
import resources.CustomColors;
import resources.font.PixelFont;

public class SettingsPanel extends JPanel {
    public SettingsPanel(PagesContext context) {
        setLayout(new BorderLayout());
        setBackground(CustomColors.redishBrown());

        JLabel title = new JLabel("Settings");
        title.setFont(PixelFont.createFont(50));
        add(title, BorderLayout.NORTH);
    }
}
