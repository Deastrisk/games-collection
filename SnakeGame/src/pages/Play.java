package pages;

import javax.swing.JFrame;

public class Play implements Page {
    private JFrame frame;
    public Play(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void display() {
        // System.out.println("h")
    }

    @Override
    public void handle(PagesContext context) {
        display();
    }
}
