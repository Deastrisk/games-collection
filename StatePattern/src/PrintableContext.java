public class PrintableContext {
    private PrintableState currentState;

    public PrintableContext() {
        currentState = new HelloWorld();
    }

    public void setState(PrintableState state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle(this);
    }
}
