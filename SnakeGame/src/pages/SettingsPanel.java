package pages;

import java.awt.*;
import javax.swing.*;
import resources.CustomColors;
import resources.font.PixelFont;

public class SettingsPanel extends JPanel {
    private final JPanel settingsPanel;
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

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;

        add(settingsScrollPanel);
    }

    private class Setting {
        public static void createCheckBox(String text) {
            
        }
    }
}
