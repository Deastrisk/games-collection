public class CreateSimHousehold implements Pages<Integer> {
    public CreateSimHousehold(HouseholdData household, String name) {
        
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
    public PageType handleInput(Integer inp) {
        switch (inp) {
            case 1: return PageType.CREATE_SIM;
            case 2: return PageType.MANAGE_HOUSEHOLD;
            case 3: return PageType.START;
            default: return PageType.MAIN_MENU;
        }
    }
}
