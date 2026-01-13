import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FourPanel extends JPanel {
    public FourPanel(Context context) {
        this.setBackground(Color.BLACK);
        JButton btn = new JButton("4");
        btn.addActionListener(e ->
            context.setState(new OneState())
        );
        this.add("4", btn);
    }
}
