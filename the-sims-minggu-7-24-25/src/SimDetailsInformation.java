public class SimDetailsInformation extends SimDetailsSelect {
    // private HouseholdData householdData;
    // private Text householdName;
    private Sims sim;
    private final Text simName;
    // private HouseholdDetails householdDetails;

    public SimDetailsInformation(HouseholdData householdData, Text householdName, Text simName) {
        super(householdData, simName, householdName);
        this.householdName = householdName;
        this.simName = simName;
    }
    
    @Override
    public PageType IODisplay() {
        this.householdDetails = householdData.details.get(this.householdName.get());
        this.sim = householdDetails.getSim(simName.get());

        System.out.println("+========================+");
        System.out.println("Name: " + this.sim.name);
        System.out.println("Type: " + this.sim.getType());
        System.out.println("+------------------------+");
        System.out.println("Energy: " + this.sim.energy);
        System.out.println("Hunger: " + this.sim.hunger);
        System.out.println("Thirst: " + this.sim.thrist);
        System.out.println("Mood: " + this.sim.mood);
        System.out.println("+------------------------+");
        
        System.out.println("Skills:");
        if (this.sim.skills == null || this.sim.skills.isEmpty()) {
            System.out.println("No skills yet.");
        } else {
            for (Skill skill : this.sim.skills) {
                System.out.println(" - " + skill.name + " Skill (" + skill.level + "/10)");
            }
        }
        
        System.out.println("+------------------------+");

        System.out.println("Friends:");
        if (this.sim.friends == null || this.sim.friends.isEmpty()) {
            System.out.println("No friends yet.");
        } else {
            for (Friend friend : this.sim.friends) {
                System.out.println(" - " + friend.name + " (" + friend.getFriendshipStatus() + ")");
            }
        }

        System.out.println("+========================+");
        int inp = getInput();
        return handleInput(inp);
    }

    @Override
    public Integer getInput() {
        App.scanner.nextLine();
        return 0;
    }

    @Override
    public PageType handleInput(Object inp) {
        return PageType.MANAGE_HOUSEHOLD_INFORMATION;
    }
}
