
public class ManageHouseholdSelect implements Pages {
    HouseholdData household;
    Wrapper<String> householdName;

    public ManageHouseholdSelect(HouseholdData household, Wrapper<String> name) {
        this.household = household;
        this.householdName = name;
    }

    @Override
    public PageType IODisplay() {
        System.out.println("+=================+");
        System.out.println("Select a household:");
        System.out.println("1. Willow Creek");
        System.out.println("2. Oasis Springs");
        System.out.println("3. Newcrest");
        System.out.println("+=================+");

        int inp = getInput();
        return handleInput(inp);
    }

    @Override
    public Integer getInput() {
        while (true) {
            System.out.print(">> ");

            String inpStr = App.scanner.nextLine();
            try {
                int inp = Integer.parseInt(inpStr);
                if (inp < 1 || inp > 3) {
                    System.out.println("Input must be between 1-3");
                    continue;
                }
                return inp;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number");
            }
        }
    }

    @Override
    public PageType handleInput(Object inp) {
        switch ((int) inp) {
            case 1: 
                householdName.set("Willow Creek");
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;
            case 2: 
                householdName.set("Oasis Springs");
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;
            case 3: 
                householdName.set("Newcrest");
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;

            default: return PageType.MAIN_MENU;
        }
    }
}
