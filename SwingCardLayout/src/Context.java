import java.awt.*;

public class Context {
    private State currentState;
    private Container container;
    private CardLayout cardLayout;

    public Context() {
        currentState = new One();
    }

    public void request(State state) {
        state.handle(this);
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public Container getContainer() { return container; }
    public CardLayout getCardLayout() { return cardLayout; }
}
