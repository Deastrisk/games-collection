import java.util.Map;
import java.util.Scanner;

public class App {
    public static final Scanner scanner = new Scanner(System.in);
    PageType page = PageType.START;

    private final Map<PageType, Pages> pages = Map.ofEntries(
        Map.entry(PageType.START, new Start())
    );

    public static void main(String[] args) throws Exception {
        App game = new App();
        while (true) { 
            // gets page's display
            game.page = game.pages.get(game.page).IODisplay();
            if (game.page == PageType.EXIT) return;
        }
    }
}
