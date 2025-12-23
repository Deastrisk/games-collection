import java.awt.Dimension;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame();

        window.setVisible(true);
        window.setPreferredSize(new Dimension(600, 400));
        window.setTitle("Shape Creator");
        window.setLayout(null);
    }
}
