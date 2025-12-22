import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setTitle("Calculator");
        window.setResizable(false);
        window.setSize(300, 400);
        window.setVisible(true);
        window.setLayout(null);

        JButton button = new JButton();
        button.setSize(30, 30);
        button.setVisible(true);
        window.add(button);
    }
}
