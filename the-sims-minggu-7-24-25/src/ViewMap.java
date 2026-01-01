public class ViewMap implements Pages {
    private final HouseholdData householdData;
    private final Text householdName;
    private final Text simName;

    public ViewMap(HouseholdData householdData, Text householdName, Text selectedSimName) {
        this.householdData = householdData;
        this.householdName = householdName;
        this.simName = selectedSimName;
    }

    @Override
    public PageType IODisplay() {
        HouseholdDetails householdDetails = householdData.details.get(householdName.get());
        SimsMap map = householdDetails.map;
        while (true) {
            // 13
            System.out.println("+=============+");
            for (int i = 0; i < map.height(); i++) {
                System.out.print("|");
                for (int j = 0; j < map.width(); j++) {
                    System.out.print(map.get(i, j));
                }
                System.out.println("|");
            }
            System.out.println("+=============+");
            break;
        }
        return PageType.CREATE_SIM_HOUSEHOLD;
    }

    @Override
    // handles chars
    public PageType handleInput(Object inp) {
        return PageType.CREATE_SIM_HOUSEHOLD;
    }

    @Override
    public Character getInput() {
        while (true) { 
            String inpStr = App.scanner.nextLine();
            if (inpStr == null || !inpStr.isEmpty()) {
                System.out.println("Must input a char.");
                continue;
            }
            
            return inpStr.charAt(0);
        }
    }
}
