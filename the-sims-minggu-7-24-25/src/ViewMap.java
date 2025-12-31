public class ViewMap implements Pages<Character> {
    private HouseholdData householdData;
    private Text householdName;
    private Text simName;

    public ViewMap(HouseholdData householdData, Text householdName, Text selectedSimName) {
        this.householdData = householdData;
        this.householdName = householdName;
        this.simName = selectedSimName;
    }

    @Override
    public PageType IODisplay() {
        while (true) { 
            break;
        }
        return PageType.CREATE_SIM_HOUSEHOLD;
    }

    @Override
    public PageType handleInput(Character inp) {
        return PageType.CREATE_SIM_HOUSEHOLD;
    }

    @Override
    public Character getInput() {
        return 's';
    }
}
