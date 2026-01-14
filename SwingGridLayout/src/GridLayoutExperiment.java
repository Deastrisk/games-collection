import java.awt.*;
import javax.swing.*;

public class GridLayoutExperiment extends JPanel {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        GridLayoutExperiment panel = new GridLayoutExperiment();
        frame.add(panel);
        frame.setSize(new Dimension(1000, 600));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public GridLayoutExperiment() {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        this.add(titlePanel, BorderLayout.NORTH);
        
        JLabel title = new JLabel("Snake Game");
        title.setFont(new Font(null));
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.CYAN));
        title.setForeground(Color.BLACK);
        titlePanel.add(title);

        JPanel credits = new JPanel();
        credits.setBackground(Color.GREEN);
        credits.setLayout(new BoxLayout(credits, BoxLayout.Y_AXIS));
        credits.setAlignmentX(Component.CENTER_ALIGNMENT);
        credits.setAlignmentX(Component.TOP_ALIGNMENT);
        
        JScrollPane scrollPane = new JScrollPane(credits);
        scrollPane.setBackground(Color.GREEN);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        JLabel creator = new JLabel("Amadeus Marcio Sutanto");
        creator.setFont(new Font("SansSerif", Font.BOLD, 20));
        // creator.setForeground(CustomColors.lightGreen());
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

        JPanel row = new JPanel();
        row.setLayout(new GridBagLayout());
        row.setBackground(Color.MAGENTA);
        row.setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.insets = new Insets(4, 4, 4, 8);

        JPanel split = new JPanel();
        split.setLayout(new GridLayout(1, 2, 0, 0));
        split.setOpaque(true);
        
        split.setBackground(Color.BLUE);
        
        JLabel roleLabel = new JLabel(role);
        roleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        roleLabel.setForeground(Color.DARK_GRAY);
        roleLabel.setAlignmentY(JLabel.NORTH_EAST);
        roleLabel.setHorizontalAlignment(JLabel.RIGHT);
        roleLabel.setVerticalAlignment(JLabel.TOP);
        roleLabel.setBackground(Color.LIGHT_GRAY);
        roleLabel.setOpaque(true);
        
        // gbc.gridx = 0;
        // gbc.anchor = GridBagConstraints.NORTHEAST;
        // gbc.insets = new Insets(4, 4, 4, 4);
        split.add(roleLabel);
        
        JPanel creditsPanel = new JPanel();
        creditsPanel.setOpaque(false);
        creditsPanel.setLayout(new BoxLayout(creditsPanel, BoxLayout.Y_AXIS));

        // gbc.gridx = 1;
        // gbc.anchor = GridBagConstraints.NORTHWEST;
        // gbc.insets = new Insets(4, 8, 4, 4);
        split.add(creditsPanel);
        
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
        
        row.add(split);
        container.add(row);
        row.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, split.getPreferredSize().height)
        );
    }
}
