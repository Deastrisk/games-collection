import java.util.InputMismatchException;

public class MainMenu implements Menu {
    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| MENU");
        System.out.println("+---------------+");
        System.out.println("| 1. Shapes");
        System.out.println("| 0. Exit");
        System.out.println("+---------------+");

        int inp = getInput();
        return handleInput(inp);
    }

    @Override
    public MenuType handleInput(int input) {
        switch (input) {
            case 0: return MenuType.EXIT;
            case 1: return MenuType.SHAPES;
            default: return MenuType.MAIN;
        }
    }

    @Override
    public int getInput() {
        while (true) { 
            System.out.print("| >> ");

            // validates input
            int inp;
            try {
                inp = App.scanner.nextInt();
            } catch (InputMismatchException e) {
                continue;
            } finally {
                App.scanner.nextLine();
            }

            if (inp >= 0 && inp <= 1) return inp;
        }
    }
}
