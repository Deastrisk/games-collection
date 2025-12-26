import java.awt.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        // creates window
        JFrame window = new JFrame();
        window.setTitle("Shoppy");

        // creates buttons
        JButton btn0 = new JButton("Login");
        btn0.setBounds(50, 50, 100, 50);
        window.add(btn0);
        JButton btn1 = new JButton("Sign In");
        btn1.setBounds(160, 50, 100, 50);
        window.add(btn1);
        JButton btn2 = new JButton("Exit");
        btn2.setBounds(270, 50, 100, 50);
        window.add(btn2);

        // checkbox
        JLabel label = new JLabel("Select language");
        label.setBounds(50, 110, 200, 20);
        window.add(label);

        Checkbox c0 = new Checkbox("English");
        c0.setBounds(50, 130, 200, 20);
        window.add(c0);
        Checkbox c1 = new Checkbox("Indonesian");
        c1.setBounds(50, 150, 200, 20);
        window.add(c1);
        Checkbox c2 = new Checkbox("Japanese");
        c2.setBounds(50, 170, 200, 20);
        window.add(c2);

        // sets window size
        window.setSize(new Dimension(600, 360));

        // used when there is a layout manager
        // window.setPreferredSize(new Dimension(600, 360));

        // no layout manager
        window.setLayout(null);
        window.setVisible(true);
    }
}
