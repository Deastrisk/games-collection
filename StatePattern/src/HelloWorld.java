public class HelloWorld implements PrintableState {
    @Override
    public void printPrintables() {
        System.out.println("Hello world.");
        System.out.println("1. Amajing");
        System.out.println("0. Exit");
        System.out.print(">> ");
    }

    private int getInput() {
        String inpStr = App.scanner.nextLine();
        try {
            int inp = Integer.parseInt(inpStr);
            return inp;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private PrintableState handleInput(int inp) {
        switch (inp) {
            case 0: return new Exit();
            case 1: return new Amajing();
            default: return new HelloWorld();
        }
    }

    @Override
    public void handle(PrintableContext context) {
        printPrintables();
        int inp = getInput();
        context.setState(handleInput(inp));
    }
}
