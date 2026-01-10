public class Amajing implements PrintableState {
    public void printPrintables() {
        System.out.println("Amajing!");
    }

    @Override
    public void handle(PrintableContext context) {
        printPrintables();
        context.setState(new HelloWorld());
    }
}
