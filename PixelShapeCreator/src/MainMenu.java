import java.text.spi.NumberFormatProvider;
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

        int inp = (int) getInput();
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
            String inpStr = App.scanner.nextLine();
            try {
                int inp = Integer.parseInt(inpStr);
                if (inp < 0 || inp > 1) {
                    System.out.println("| Input must be between 0-1");
                    continue;
                }
                return inp;
            } catch (NumberFormatException e) {
                System.out.println("| Input Must be a number.");
            }
        }
    }
}
