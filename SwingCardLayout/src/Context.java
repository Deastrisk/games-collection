import java.awt.*;

public class Context {
    public State currentState;
    private final Container container;
    private final CardLayout cardLayout;

    public Context(Container container, CardLayout cardLayout) {
        this.container = container;
        this.cardLayout = cardLayout;
    }

    // private Container getContainer() { return this.container; }
    // private CardLayout getCardLayout() { return this.cardLayout; }

    public void showCard(States name) {
        cardLayout.show(container, name.name());
    }
    
    public void setState(State state) {
        if (currentState != null) {
            currentState.exit(this);
        }
        currentState = state;
        currentState.enter(this);
    }

    // public String getState() { return currentState.getState(); }
}
