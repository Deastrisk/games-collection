public class SimDetailsSelect implements Pages<Integer> {
    private HouseholdDetails householdDetails;
    private Text selectedSimName;

    public SimDetailsSelect(HouseholdDetails householdDetails, Text selectedSimName) {
        this.householdDetails = householdDetails;
        this.selectedSimName = selectedSimName;
    }

    @Override
    public PageType IODisplay() {
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
            } catch (Exception e) {
                System.out.println("Input must be a number");
            }
        }
    }

    @Override
    public PageType handleInput(Integer inp) {

        selectedSimName.set(householdDetails.getSim(inp).name);
        return PageType.SIM_DETAILS_INFORMATION;
    }
}
