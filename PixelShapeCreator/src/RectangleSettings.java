public class RectangleSettings extends RectangleMenu {

    @Override
    public MenuType IODisplay() {
        System.out.println("+---------------+");
        System.out.println("| Rectangle Settings");
        System.out.println("+---------------+");
        System.out.print("| Set Height : ");
        state.height = getInput();
        System.out.print("| Set Width  : ");
        System.out.println("+---------------+");
    }

    @Override
    public int getInput() {
        
    }
}
