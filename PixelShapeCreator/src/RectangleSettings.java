public class RectangleSettings extends RectangleMenu {
    RectangleSettings(RectangleState state) {
        super(state);
    }
    
    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| Rectangle Settings");
        System.out.println("+---------------+");

        System.out.print("| Set Height : ");
        state.height = getInput();

        System.out.print("| Set Width  : ");
        state.width = getInput();

        System.out.println("+---------------+");

        int validator = (state.height == -1 || state.width == -1) ? -1 : 0;
        return handleInput(validator);
    }

    @Override
    public int getInput() {
        String inpStr = App.scanner.nextLine();
        try {
            int inp = Integer.parseInt(inpStr);
            if (inp < 0) return -1;
            return inp;
        } catch (NumberFormatException e) {}
        return -1;
    }

    @Override
    public MenuType handleInput(int input) {
        if (input == -1) {
            System.out.println("| Invalid Input.");
            System.out.println("| Width and height failed set.");
        } else {
            System.out.println("| Width and height successfully set.");
        }
        return MenuType.RECTANGLE;
    }
}
