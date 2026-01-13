import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OnePanel extends JPanel {
    public OnePanel(Context context) {
        this.setBackground(Color.BLACK);
        JButton btn1 = new JButton("1");
        btn1.addActionListener(e ->
            context.setState(new TwoState())
        );
        this.add("1", btn1);
    }
}
