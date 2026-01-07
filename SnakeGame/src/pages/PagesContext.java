package pages;

import javax.swing.*;

public class PagesContext {
    private Page currentPage;

    public PagesContext(JFrame frame) {
        currentPage = new TitleScreen(frame);
    }

    public void setPage(Page newPage) {
        currentPage = newPage;
    }

    public void display() {
        currentPage.display();
    }
}
