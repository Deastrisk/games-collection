import java.util.Map;
import java.util.Scanner;

public class App {
    public static final Scanner scanner = new Scanner(System.in);
    PageType page = PageType.START;
    HouseholdData householdData = new HouseholdData();
    Text houseName = new Text();
    Text selectedSimName = new Text();

    private final Map<PageType, Pages> pages = Map.ofEntries(
        Map.entry(PageType.START, new Start()),
        Map.entry(PageType.MAIN_MENU, new MainMenu(householdData)),
        Map.entry(PageType.CREATE_SIM_HOUSEHOLD, new CreateSimHousehold(householdData, houseName)),
        Map.entry(PageType.CREATE_SIM_TYPE, new CreateSimType(householdData, houseName)),
        Map.entry(PageType.MANAGE_HOUSEHOLD_SELECT, new ManageHouseholdSelect(householdData, houseName)),
        Map.entry(PageType.MANAGE_HOUSEHOLD_INFORMATION, new ManageHouseholdInformation(householdData, houseName)),
        Map.entry(PageType.SIM_DETAILS_SELECT, new SimDetailsSelect(householdData, selectedSimName, houseName)),
        Map.entry(PageType.SIM_DETAILS_INFORMATION, new SimDetailsInformation(householdData, houseName, selectedSimName)),
        Map.entry(PageType.MAP_SELECT, new ViewMapSelect(householdData, houseName, selectedSimName)),
        Map.entry(PageType.MAP, new ViewMap(householdData, houseName, selectedSimName))
    );

    public static void main(String[] args) throws Exception {
        App game = new App();
        while (true) { 
            // gets page's display
            game.page = game.pages.get(game.page).IODisplay();
            if (game.page == PageType.EXIT) return;
        }
    }

    // public static char getch() {

    // }
}
