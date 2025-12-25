import java.util.InputMismatchException;

public class SquareMenu implements Menu {
    protected SquareState state;

    public SquareMenu(SquareState state) {
        this.state = state;
    }

    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| Square");
        System.out.println("+---------------+");
        System.out.println("| Width     : " + state.width);
        System.out.println("| Area      : " + state.getArea());
        System.out.println("| Perimeter : " + state.getPerimeter());
        System.out.println("+---------------+");
        System.out.println("| 1. Settings");
        System.out.println("| 0. Exit");
        System.out.println("+---------------+");
        state.printShape();

        System.out.println("+---------------+");
        int inp = getInput();
        return handleInput(inp);
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
            System.out.print("| >> ");

            String inpStr = App.scanner.nextLine();
            try {
                int inp = Integer.parseInt(inpStr);
                if (inp < 0 || inp > 1) {
                    System.out.println("| Input must be between 0-1.");
                    continue;
                }
                return inp;
            } catch (NumberFormatException e) {
                System.out.println("| Input must be a number.");
            }
        }
    }
}
