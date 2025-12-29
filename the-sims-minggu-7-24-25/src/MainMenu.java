

public class MainMenu implements Pages<Integer> {
    private HouseholdData household;

    public MainMenu(HouseholdData household) {
        this.household = household;
    }

    @Override
    public PageType IODisplay() {
        System.out.println("+================ SIMS ==============+");
        System.out.println("|        NEIGHBORHOOD HOUSEHOLD      |");
        System.out.println("+------------------------------------+");
        System.out.printf("| 1. Willow Creek - Residents: %-6s|\n", household.residents.get("Willow Creek"));
        System.out.printf("| 2. Oasis Springs - Residents: %-5s|\n", household.residents.get("Oasis Springs"));
        System.out.printf("| 3. Newcrest - Residents: %-10s|\n", household.residents.get("Newcrest"));
        System.out.println("+====================================+");
        System.out.println("| 1. Create a Sim                    |");
        System.out.println("| 2. Manage a Household              |");
        System.out.println("| 3. Exit Game                       |");
        System.out.println("+====================================+");

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
    public PageType handleInput(Integer inp) {
        switch (inp) {
            case 1: return PageType.CREATE_SIM;
            case 2: return PageType.MANAGE_HOUSEHOLD;
            case 3: return PageType.START;
            default: return PageType.MAIN_MENU;
        }
    }
}
