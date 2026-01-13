import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TwoPanel extends JPanel {
    public TwoPanel(Context context) {
        this.setBackground(Color.BLACK);
        JButton btn1 = new JButton("2");
        btn1.addActionListener(e ->
            context.setState(new ThreeState())
        );
        this.add("2", btn1);
    }
}
