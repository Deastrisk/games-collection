
public class ViewMapSelect implements Pages {
    protected HouseholdData householdData;
    protected Wrapper<String> selectedSimName;
    protected HouseholdDetails householdDetails;
    protected Wrapper<String> householdName;

    public ViewMapSelect(HouseholdData householdData, Wrapper<String> householdName, Wrapper<String> selectedSimName) {
        this.householdData = householdData;
        this.selectedSimName = selectedSimName;
        this.householdName = householdName;
    }
    
    @Override
    public PageType IODisplay() {
        this.householdDetails = householdData.details.get(householdName.get());

        System.out.println("Select a Sim to View Details:");
        if (householdDetails.getCount() == 0) {
            System.out.println("No Sims available in this Household.");
            System.out.print(">> ");

            App.scanner.nextLine();
            return PageType.MANAGE_HOUSEHOLD_INFORMATION;
        }

        for (int i = 0; i < householdDetails.getCount(); i++) {
            System.out.println((i + 1) + ". " + householdDetails.getSim(i).name);
        }

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
                if (inp < 1 || inp > householdDetails.getCount()) {
                    System.out.println("Selected a nonexistent Sim");
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
        selectedSimName.set(householdDetails.getSim((int) inp - 1).name);
        return PageType.MAP;
    }
}
