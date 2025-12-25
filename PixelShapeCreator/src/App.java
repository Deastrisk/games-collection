import java.util.Map;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    SquareState squareState = new SquareState();
    RectangleState rectangleState = new RectangleState();

    private final Map<MenuType, Menu> menus = Map.ofEntries(
        Map.entry(MenuType.MAIN, new MainMenu()),
        Map.entry(MenuType.SHAPES, new ShapeMenu()),
        Map.entry(MenuType.SQUARE, new SquareMenu(squareState)),
        Map.entry(MenuType.SQUARE_SETTINGS, new SquareSettings(squareState)),
        Map.entry(MenuType.RECTANGLE, new RectangleMenu(rectangleState)),
        Map.entry(MenuType.RECTANGLE_SETTINGS, new RectangleSettings(rectangleState))
        // Map.entry(MenuType.CIRCLE, new CircleMenu(circleState)),
        // Map.entry(MenuType.CIRCLE_SETTINGS, new CircleSettings(circleState)),
        // Map.entry(MenuType.TRIANGLE, new TriangleMenu(triangleState)),
        // Map.entry(MenuType.TRIANGLE_SETTINGS, new TriangleSettings(triangleState))
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
