package pages;

import java.awt.*;
import javax.swing.*;
import resources.CustomColors;
import resources.font.PixelFont;

public class SettingsPanel extends JPanel {
    private final JPanel settingsPanel;
    private final GridBagConstraints gbc;
    private int settingsCount;

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

        settingsCount = 0;

        gbc = new GridBagConstraints();

        add(settingsScrollPanel);
    }

    public void createKeybind(String text) {
        gbc.gridx = 0;
        gbc.gridy = settingsCount;
        gbc.weightx = 0;
        gbc.weighty = 1;
    }
}
