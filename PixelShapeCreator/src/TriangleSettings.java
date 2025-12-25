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
        state.base = getInput();
        System.out.print("| Set a    : ");
        state.a = getInput();
        System.out.print("| Set b    : ");
        state.b = getInput();

        int validator = 1;
        if (state.base == -1 || state.a == -1 || state.b == -1) {
            validator = -1;
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
