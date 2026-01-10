package pages;

import javax.swing.JPanel;

public interface Page {
    public void display(JPanel panel);
    public void handle(PagesContext context);
}
