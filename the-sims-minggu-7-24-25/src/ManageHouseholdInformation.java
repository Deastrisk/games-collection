public class ManageHouseholdInformation implements Pages<Integer> {
    HouseholdData household;
    Text householdName;
    HouseholdDetails householdDetails;

    public ManageHouseholdInformation(HouseholdData household, Text name) {
        this.household = household;
        this.householdName = name;
    }
    
    @Override
    public PageType IODisplay() {
        this.householdDetails = household.residents.get(householdName.get());
        
        System.out.println("+======================+");
        System.out.println(householdName.get().toUpperCase());
        System.out.println("+======================+");
        System.out.println("Residents: " + householdDetails.getCount());
        if (householdDetails.getCount() == 0) {
            System.out.println(" - No residents");
        } else {
            for (int i = 0; i < householdDetails.getCount(); i++) {
                System.out.println(" - " + householdDetails.getSim(i).name);
            }
        }

        System.out.println("+======================+");
        System.out.println("| 1. See Sim Details   |");
        System.out.println("| 2. View Map          |");
        System.out.println("| 0. Exit              |");
        System.out.println("+======================+");

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
                if (inp < 0 || inp > 2) {
                    System.out.println("Input must be between 0-2");
                    continue;
                }
                return inp;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number");
            }
        }
    }

    @Override
    public PageType handleInput(Integer inp) {
        switch (inp) {
            case 0: return PageType.MAIN_MENU;
            case 1: return PageType.SIM_DETAILS_SELECT;
            case 2: return PageType.MAP;
            default: return PageType.MANAGE_HOUSEHOLD_INFORMATION;
        }
    }
}
