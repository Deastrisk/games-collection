public class TriangleMenu implements Menu {
    TriangleState state;
    TriangleMenu(TriangleState state) {
        this.state = state;
    }

    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| Square");
        System.out.println("+---------------+");
        System.out.println("| a         : " + state.a);
        System.out.println("| b         : " + state.b);
        System.out.println("| base      : " + state.base);
        System.out.println("| height    : " + state.getHeight());
        System.out.println("| Area      : " + state.getArea());
        System.out.println("| Perimeter : " + state.getPerimeter());
        System.out.println("+---------------+");
        System.out.println("| 1. Settings");
        System.out.println("| 0. Exit");
        System.out.println("+---------------+");
        state.printShape();
        int var1 = this.getInput();
        return this.handleInput(var1);
    }

    @Override
    public int getInput() {
        while (true) {
            System.out.print("| >> ");

            String inpStr = App.scanner.nextLine();
            try {
                int inp = Integer.parseInt(inpStr);
                if (inp < 0 || inp > 1) {
                    System.out.println("| Input must be between 0-1");
                    continue;
                }
                return inp;
            } catch (NumberFormatException e) {
                System.out.println("| Input must be a number.");
            }
        }
    }

    @Override
    public MenuType handleInput(int input) {
        switch (input) {
            case 0: return MenuType.SHAPES;
            case 1: return MenuType.TRIANGLE_SETTINGS;
            default: return MenuType.TRIANGLE;
        }
    }
}
