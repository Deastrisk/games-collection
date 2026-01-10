package pages;

public class Play implements Page {
    @Override
    public void display() {
        // System.out.println("h")
    }

    @Override
    public void handle(PagesContext context) {
        display();
    }
}
