public class Exit implements PrintableState {
    @Override
    public void printPrintables() {
        System.out.println("Exiting program...");
    }

    @Override
    public void handle(PrintableContext context) {
        printPrintables();
        System.exit(0);
    }
}
