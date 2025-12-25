import java.util.Map;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    SquareState squareState = new SquareState();

    private final Map<MenuType, Menu> menus = Map.ofEntries(
        Map.entry(MenuType.MAIN, new MainMenu()),
        Map.entry(MenuType.SHAPES, new ShapeMenu()),
        Map.entry(MenuType.SQUARE, new SquareMenu(squareState)),
        Map.entry(MenuType.SQUARE_SETTINGS, new SquareSettings(squareState))
    );

    private MenuType currentType = MenuType.MAIN;
    
    public static void main(String[] args) throws Exception {
        App app = new App();
        while (true) {
            Menu currentMenu = app.menus.get(app.currentType);

            // pages logic
            app.currentType = currentMenu.IODisplay();

            // returns if exit
            if (app.currentType.equals(MenuType.EXIT)) break;
        }
    }
}
