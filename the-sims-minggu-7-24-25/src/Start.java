

public class Start implements Pages {
    @Override
    public PageType IODisplay() {
        System.out.println("+===================+");
        System.out.println("|  The Sims Deluxe  |");
        System.out.println("+===================+");
        System.out.println("| 1. Play           |");
        System.out.println("| 2. Exit           |");
        System.out.println("+===================+");
        int inp = getInput();
        return handleInput(inp);
    }

    @Override
    public Integer getInput() {
        while (true) {
            System.out.print(">> ");

            String inpStr = App.scanner.nextLine();
            try {
                int inp = Integer.parseInt(inpStr);
                if (inp < 1 || inp > 2) {
                    System.out.println("Input must be either 1 or 2");
                    continue;
                }
                return inp;
            } catch (NumberFormatException e) {
                System.out.println("Input must be number.");
            }
        }
    }

    @Override
    public PageType handleInput(Object inp) {
        switch ((int) inp) {
            case 1: return PageType.MAIN_MENU;
            case 2: return PageType.EXIT;
            default: return PageType.START;
        }
    }
}
