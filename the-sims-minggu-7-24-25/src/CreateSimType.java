
public class CreateSimType extends CreateSimHousehold {
    String name = null;

    public CreateSimType(HouseholdData household, Text householdName) {
        super(household, householdName);
        this.name = householdName.get();
    }

    @Override
    public PageType IODisplay() {
        System.out.println("+====================+");
        System.out.println("Choose a Sim to play:");
        System.out.println("1. Human Sim");
        System.out.println("2. Vampire Sim");
        System.out.println("3. Alien Sim");
        System.out.println("+====================+");

        int inp = getInput();

        System.out.print("Enter the name of your " + simType(inp) + " Sim: ");
        this.name = App.scanner.nextLine();
        System.out.println(name + " joined the neighborhood.");
        System.out.println(name + " feels fine.");

        PageType retval = handleInput(inp);
        return retval;
    }

    private String simType(int inp) {
        switch (inp) {
            case 1: return "Human";
            case 2: return "Vampire";
            case 3: return "Alien";
        }
        return "";
    }

    @Override
    public PageType handleInput(Object input) {
        switch ((int) input) {
            case 1: 
                household.details.get(householdName.get()).addSims(new Human(name));
                return PageType.MAIN_MENU;
            case 2: 
                household.details.get(householdName.get()).addSims(new Vampire(name));
                return PageType.MAIN_MENU;
            case 3: 
                household.details.get(householdName.get()).addSims(new Alien(name));
                return PageType.MAIN_MENU;
            default: return PageType.MAIN_MENU;
        }
    }
}
