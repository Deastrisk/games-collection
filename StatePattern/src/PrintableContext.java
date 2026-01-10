public class PrintableContext {
    private PrintableState currentState;

    public PrintableContext() {
        currentState = new HelloWorld();
    }

    public setState(PrintableState state) {
        this.currentState = state;
    }

    public void request() {
        
    }
}
