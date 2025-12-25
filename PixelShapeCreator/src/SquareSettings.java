
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

        state.width = getInput();

        
        System.out.println("+---------------+");
        System.out.println("| Square width set!");

        return MenuType.SQUARE;
    }

    @Override
    public MenuType handleInput(int input) {
        return MenuType.SQUARE;
    }

    @Override
    public int getInput() {
        while (true) {
            String inp = App.scanner.nextLine().trim();
            try {
                return Integer.parseInt(inp);
            } catch (NumberFormatException e) {}
        }
    }
}
