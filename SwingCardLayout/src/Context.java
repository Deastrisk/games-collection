import java.awt.*;
import javax.swing.*;

public class Context {
    private State currentState;
    private final Container content;
    private final CardLayout cardLayout;

    public Context(JFrame frame) {
        currentState = new One();
        cardLayout = new CardLayout();
        content = frame.getContentPane();
    }

    public void initializeStates() {
        if (!currentState.hasBeenLoaded()) {
            currentState.load(this);
        }
    }

    public void request() {
        currentState.handle(this);
    }

    public Container getContainer() { return content; }
    public CardLayout getCardLayout() { return cardLayout; }
    
    public void setState(State state) { this.currentState = state; }
}
