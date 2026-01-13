public class HelloWorld implements PrintableState {
    public void printPrintables() {
        System.out.println("Hello world.");
        System.out.println("1. Amajing");
        System.out.println("2. Set Person Data");
        System.out.println("3. Display Person Information");
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

    private PrintableState handleInput(int inp, Person person) {
        switch (inp) {
            case 0: return new Exit();
            case 1: return new Amajing();
            case 2: return new EditPerson();
            case 3: return new PersonInformation();
            default: return new HelloWorld();
        }
    }

    @Override
    public void handle(PrintableContext context) {
        printPrintables();
        int inp = getInput();
        context.setState(handleInput(inp, context.getPerson()));
    }
}
