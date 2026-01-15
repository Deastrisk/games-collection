package pages;

import java.awt.*;
import javax.swing.*;
import resources.CustomColors;
import resources.font.PixelFont;

public class SettingsPanel extends JPanel {
    private final JPanel settingsPanel;
    private final GridBagConstraints gbc;

    public SettingsPanel(PagesContext context) {
        setLayout(new BorderLayout());
        setBackground(CustomColors.redishBrown());

        JLabel title = new JLabel("Settings");
        title.setFont(PixelFont.createFont(50));
        title.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 40));
        add(title, BorderLayout.NORTH);

        settingsPanel = new JPanel();

        JScrollPane settingsScrollPanel = new JScrollPane(settingsPanel);
        settingsScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        
        settingsPanel.setBackground(CustomColors.redishBrown());
        settingsPanel.setOpaque(true);
        settingsPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 40));
        settingsPanel.setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();

        add(settingsScrollPanel);
    }

    private class Setting {
        // public static void createCheckBox(String text) {
            
        // }

        public static void createKeybind(String text) {
            gbc.gridx = 0;
        }
    }
}
