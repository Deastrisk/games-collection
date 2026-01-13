public class PrintableContext {
    private PrintableState currentState;
    private final Person person;

    public PrintableContext() {
        currentState = new HelloWorld();
        person = new Person(null, null, -1, -1);
    }

    public void setState(PrintableState state) {
        this.currentState = state;
    }
    
    public void request() {
        currentState.handle(this);
    }

    public Person getPerson() { return person; }
}
