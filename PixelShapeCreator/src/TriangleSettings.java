public class TriangleSettings extends TriangleMenu {
    public TriangleSettings(TriangleState state) {
        super(state);
    }

    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| Triangle Settings");
        System.out.println("+---------------+");
        
        System.out.print("| Set base : ");
        int base = getInput();
        System.out.print("| Set a    : ");
        int a = getInput();
        System.out.print("| Set b    : ");
        int b = getInput();

        int validator = 1;
        if (base == -1 || a == -1 || b == -1) {
            validator = -1;
        }

        if (validator != -1) {
            state.base = base;
            state.a = a;
            state.b = b;
        }

        System.out.println("+---------------+");
        return handleInput(validator);
    }

    @Override
    public int getInput() {
        String inpStr = App.scanner.nextLine();
        try {
            int inp = Integer.parseInt(inpStr);
            if (inp <= 0) return -1;
            return inp;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public MenuType handleInput(int input) {
        if (input == -1) {
            System.out.println("| Invalid Input.");
            System.out.println("| Base, a, and b failed to set.");
        } else {
            System.out.println("| Base, a, and b successfully set.");
        }
        return MenuType.TRIANGLE;
    }
}
