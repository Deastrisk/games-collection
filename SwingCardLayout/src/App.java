import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setLayout(new CardLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel1.setBackground(Color.BLACK);
        panel2.setBackground(Color.MAGENTA);
        panel3.setBackground(Color.CYAN);
        panel4.setBackground(Color.GREEN);

        JLabel label = new JLabel("1");
        label.setForeground(Color.WHITE);
        panel1.add(label, 1);
        panel2.add(new JLabel("2"), 0);
        panel3.add(new JLabel("3"), 2);
        panel4.add(new JLabel("4"), 3);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));

        frame.setVisible(true);
    }
}
