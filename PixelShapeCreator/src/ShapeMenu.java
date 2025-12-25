import java.util.InputMismatchException;

public class ShapeMenu implements Menu {
    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| SELECT SHAPE");
        System.out.println("+---------------+");
        System.out.println("| 1. Square");
        System.out.println("| 2. Rectangle");
        System.out.println("| 3. Circle");
        System.out.println("| 4. Triangle");
        System.out.println("| 0. Back to Menu");
        System.out.println("+---------------+");

        int inp = getInput();
        return handleInput(inp);
    }

    @Override
    public MenuType handleInput(int input) {
        switch (input) {
            case 0: return MenuType.MAIN;
            case 1: return MenuType.SQUARE;
            case 2: return MenuType.RECTANGLE;
            case 3: return MenuType.CIRCLE;
            case 4: return MenuType.TRIANGLE;
            default: return MenuType.SHAPES;
        }
    }

    @Override
    public int getInput() {
        while (true) { 
            System.out.print("| >> ");

            int inp;
            try {
                inp = App.scanner.nextInt();
            } catch (InputMismatchException e) {
                continue;
            } finally {
                App.scanner.nextLine();
            }

            if (inp >= 0 && inp <= 4) return inp;
        }
    }
}
