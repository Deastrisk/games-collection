
import java.util.InputMismatchException;

public class RectangleMenu implements Menu {
    protected RectangleState state;

    public RectangleMenu(RectangleState state) {
        this.state = state;
    }

    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| Square");
        System.out.println("+---------------+");
        System.out.println("| Width         : " + state.width);
        System.out.println("| Height        : " + state.height);
        System.out.println("| Area          : " + state.getArea());
        System.out.println("| Circumference : " + state.getCircumference());
        System.out.println("+---------------+");
        System.out.println("| 1. Settings");
        System.out.println("| 0. Exit");
        System.out.println("+---------------+");
        printShape();

        int inp = getInput();
        return handleInput(inp);
    }

    private void printShape() {
        for (int i = 0; i < state.height; i++) {
            for (int j = 0; j < state.width; j++) {
                System.out.print("##");
            }
            System.out.println();
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

            if (inp >= 0 && inp <= 1) return inp;
        }
    }

    @Override
    public MenuType handleInput(int input) {
        switch (input) {
            case 0: return MenuType.SHAPES;
            case 1: return MenuType.RECTANGLE_SETTINGS;
            default: return MenuType.RECTANGLE;
        }
    }
}