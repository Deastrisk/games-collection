package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import resources.CustomColors;
import resources.effects.Hover;
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

        addCredit(credits, "Concept", "Various", "It's just a snake game...");
        addCredit(credits, "Design", "Amadeus Marcio Sutanto");
        addCredit(credits, "Font", "04b_30 by 04");
        addCredit(credits, "Font", "04b_30 by 04");
        addCredit(credits, "Font", "04b_30 by 04");
        addCredit(credits, "Font", "04b_30 by 04");
        addCredit(credits, "Font", "04b_30 by 04");
        addCredit(credits, "Font", "04b_30 by 04");
        addCredit(credits, "Font", "04b_30 by 04");
        addCredit(credits, "Font", "04b_30 by 04");
        addCredit(credits, "Font", "04b_30 by 04");

        JButton backBtn = new JButton("Back");
        backBtn.setFont(PixelFont.createFont(30));
        backBtn.setOpaque(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
        backBtn.setBorder(BorderFactory.createEmptyBorder(15, 0, 22, 0));
        backBtn.setForeground(CustomColors.lightGreen());
        backBtn.setFocusable(false);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(e -> {
            context.showPage(Pages.TITLE_SCREEN);
        });
        backBtn.addMouseListener(new Hover(
            backBtn,
            CustomColors.lightGreen(),
            Color.WHITE
        ));
        this.add(backBtn, BorderLayout.SOUTH);
    }

    private void addCredit(JPanel container, String role, String... credits) {
        JPanel row = new JPanel();
        row.setLayout(new GridBagLayout());
        row.setOpaque(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.insets = new Insets(4, 4, 4, 4);

        JPanel split = new JPanel();
        split.setLayout(new GridLayout(1, 2, 15, 0));
        split.setOpaque(false);
        
        JLabel roleLabel = new JLabel(role);
        roleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        roleLabel.setForeground(CustomColors.lightGreen());
        roleLabel.setAlignmentY(JLabel.NORTH_EAST);
        roleLabel.setHorizontalAlignment(JLabel.RIGHT);
        roleLabel.setVerticalAlignment(JLabel.TOP);
        
        // gbc.gridx = 0;
        // gbc.anchor = GridBagConstraints.NORTHEAST;
        // gbc.insets = new Insets(4, 4, 4, 8);
        split.add(roleLabel);
        
        JPanel creditsPanel = new JPanel();
        creditsPanel.setLayout(new BoxLayout(creditsPanel, BoxLayout.Y_AXIS));
        creditsPanel.setOpaque(false);

        split.add(creditsPanel);
        
        Font creditFont = new Font("SansSerif", Font.BOLD, 16);
        for (String c : credits) {
            JLabel credit = new JLabel(c);
            credit.setFont(creditFont);
            credit.setForeground(Color.WHITE);
            creditsPanel.add(credit);
        }

        container.add(Box.createVerticalStrut(20));
        
        row.add(split);
        container.add(row);
        row.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, split.getPreferredSize().height)
        );
    }
}
