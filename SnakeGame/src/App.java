import java.awt.Dimension;
import javax.swing.JFrame;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setResizable(true);
        frame.setTitle("Simple Snake Game");
        frame.setPreferredSize(new Dimension(700, 400));

        MenuPanel mainMenu = new MenuPanel();

        frame.setVisible(true);
    }
}
