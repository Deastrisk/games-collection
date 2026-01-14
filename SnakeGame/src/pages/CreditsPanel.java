package pages;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import resources.CustomColors;
import resources.font.PixelFont;

public class CreditsPanel extends JPanel {
    public CreditsPanel(PagesContext context) {
        this.setBackground(CustomColors.darkGreen());
        this.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        this.add(titlePanel, BorderLayout.NORTH);
        
        JLabel title = new JLabel("Snake Game");
        title.setFont(PixelFont.createFont(50));
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, CustomColors.lightGreen()));
        title.setForeground(CustomColors.lightGreen());
        titlePanel.add(title);

        JPanel credits = new JPanel();
        credits.setBackground(CustomColors.darkGreen());
        credits.setLayout(new BoxLayout(credits, BoxLayout.Y_AXIS));
        credits.setAlignmentX(Component.CENTER_ALIGNMENT);
        credits.setAlignmentX(Component.TOP_ALIGNMENT);
        
        JScrollPane scrollPane = new JScrollPane(credits);
        scrollPane.setBackground(CustomColors.darkGreen());
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        JLabel creator = new JLabel("Amadeus Marcio Sutanto");
        creator.setFont(new Font("SansSerif", Font.BOLD, 20));
        creator.setForeground(CustomColors.lightGreen());
        creator.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        credits.add(creator);

        addCredit(credits, "Concept", "Various", "It's just a snake game...", "asdfas", "asdfads");
        // addCredit(credits, "Concept", "Various", "It's just a snake game...", "asdfas", "asdfads");
        // addCredit(credits, "Concept", "Various", "It's just a snake game...", "asdfas", "asdfads");
        // addCredit(credits, "Concept", "Various", "It's just a snake game...", "asdfas", "asdfads");
        
        addCredit(credits, "Design", "Amadeus Marcio Sutanto");
        addCredit(credits, "abby", "Amadeus Marcio Sutanto adfsd fsfasfasfsd");
        // addCredit(credits, "Font", "04b_30", "by 04");
        // addCredit(credits, "Font", "04b_30", "by 04");
        // addCredit(credits, "Font", "04b_30", "by 04");
        // addCredit(credits, "Font", "04b_30", "by 04");
        // addCredit(credits, "Font", "04b_30", "by 04", "04b_30", "by 04", "04b_30", "by 04", "04b_30", "by 04", "04b_30", "by 04","04b_30", "by 04","04b_30", "by 04");
        credits.add(Box.createVerticalStrut(100));
    }

    private void addCredit(JPanel container, String role, String... credits) {
        container.setBackground(Color.BLACK);

        // JPanel wrapper = new JPanel();
        // wrapper.setLayout(new BorderLayout());

        JPanel split = new JPanel();
        split.setLayout(new GridBagLayout());
        split.setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        
        split.setBackground(Color.BLUE);
        
        JLabel roleLabel = new JLabel(role);
        roleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        roleLabel.setForeground(CustomColors.lightGreen());
        roleLabel.setAlignmentY(JLabel.NORTH_EAST);
        roleLabel.setHorizontalAlignment(JLabel.RIGHT);
        roleLabel.setVerticalAlignment(JLabel.TOP);
        roleLabel.setBackground(Color.LIGHT_GRAY);
        roleLabel.setOpaque(true);
        
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(4, 4, 4, 8);
        split.add(roleLabel, gbc);
        
        JPanel creditsPanel = new JPanel();
        creditsPanel.setOpaque(true);
        creditsPanel.setLayout(new BoxLayout(creditsPanel, BoxLayout.Y_AXIS));

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(4, 8, 4, 4);
        split.add(creditsPanel, gbc);
        
        Font creditFont = new Font("SansSerif", Font.BOLD, 16);
        for (String c : credits) {
            JLabel credit = new JLabel(c);
            credit.setFont(creditFont);
            credit.setForeground(Color.WHITE);
            credit.setBackground(Color.GREEN);
            credit.setOpaque(true);

            creditsPanel.add(credit);
        }

        container.add(Box.createVerticalStrut(20));
        
        container.add(split);
        split.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, split.getPreferredSize().height)
        );
    }
}
