import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ThreePanel extends JPanel {
    public ThreePanel(Context context) {
        this.setBackground(Color.BLACK);
        JButton btn = new JButton("3");
        btn.addActionListener(e ->
            context.setState(new FourState())
        );
        this.add("3", btn);
    }
}
