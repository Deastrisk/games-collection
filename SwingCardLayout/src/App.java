import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App extends JFrame implements ActionListener {
    CardLayout card;
    Container container;

    App() {
        container = getContentPane();
        card = new CardLayout();

        container.setLayout(card);

        this.setLayout(card);
        this.setTitle("Numbers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.start();
    }

    public void start() {
        Context context = new Context(container, card);

        container.add(States.ONE.name(), new OnePanel(context));
        container.add(States.TWO.name(), new TwoPanel(context));
        container.add(States.THREE.name(), new ThreePanel(context));
        container.add(States.FOUR.name(), new FourPanel(context));

        context.setState(new OneState());
        this.setVisible(true);

        // JPanel panel1 = new JPanel();
        // panel1.setBackground(Color.BLACK);
        // JButton btn1 = new JButton("1");
        // btn1.addActionListener(this);
        // panel1.add("1", btn1);
        
        // JPanel panel2 = new JPanel();
        // JPanel panel3 = new JPanel();
        // JPanel panel4 = new JPanel();

        // panel2.setBackground(new Color(255, 0, 0, 150));
        // panel3.setBackground(Color.CYAN);
        // panel4.setBackground(Color.GREEN);

        // JButton btn2 = new JButton("2");
        // JButton btn3 = new JButton("3");
        // JButton btn4 = new JButton("4");

        // btn2.addActionListener(this);
        // btn3.addActionListener(this);
        // btn4.addActionListener(this);

        // panel2.add("2", btn2);
        // panel3.add("3", btn3);
        // panel4.add("4", btn4);

        // container.add(panel1);
        // container.add(panel2);
        // container.add(panel3);
        // container.add(panel4);
        
        // this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.next(container);
    }
}
