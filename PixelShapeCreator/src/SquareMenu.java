import java.util.InputMismatchException;

public class SquareMenu implements Menu {
    protected SquareState state;

    public SquareMenu(SquareState state) {
        this.state = state;
    }

    private double getArea() {
        return state.width * state.width;
    }

    private double getCircumference() {
        return 4 * state.width;
    }

    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| Square");
        System.out.println("+---------------+");
        System.out.println("| Width         : " + state.width);
        System.out.println("| Area          : " + getArea());
        System.out.println("| Circumference : " + getCircumference());
        System.out.println("+---------------+");
        System.out.println("| 1. Settings");
        System.out.println("| 0. Exit");
        System.out.println("+---------------+");
        printShape();

        int inp = getInput();
        return handleInput(inp);
    }

    private void printShape() {
        for (int i = 0; i < state.width; i++) {
            for (int j = 0; j < state.width; j++) {
                if (j == 0 || j == state.width - 1 || i == 0 || i == state.width - 1) {
                    System.out.print("##");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public MenuType handleInput(int input) {
        switch (input) {
            case 1: return MenuType.SQUARE_SETTINGS;
            case 0: return MenuType.SHAPES;
            default: return MenuType.SQUARE_SETTINGS;
        }
    }

    @Override
    public int getInput() {
        while (true) { 
            System.out.print(">> ");

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
