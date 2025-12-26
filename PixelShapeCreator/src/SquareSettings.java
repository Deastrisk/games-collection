import java.util.InputMismatchException;

public class SquareSettings extends SquareMenu {
    SquareSettings(SquareState state) {
        super(state);
    }

    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| Square Settings");
        System.out.println("+---------------+");

        System.out.print("| Set width : ");
        int width = getInput();

        if (width != -1) {
            state.width = width;
        }

        return handleInput(width);
    }

    @Override
    public MenuType handleInput(int input) {
        if (input == -1) {
            System.out.println("+---------------+");
            System.out.println("| Width must be a positive number");
            System.out.println("| Square width failed to set");
        } else {
            System.out.println("+---------------+");
            System.out.println("| Width successfully set.");
        }

        return MenuType.SQUARE;
    }

    @Override
    public int getInput() {
        String inpStr = App.scanner.nextLine();
        try {
            int inp = Integer.parseInt(inpStr);
            if (inp <= 0) return -1;
            return inp;
        } catch (NumberFormatException e) {}
        return -1;
    }
}
