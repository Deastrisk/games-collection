import java.util.Map;

public class SimDetailsInformation extends SimDetailsSelect {
    // private HouseholdData householdData;
    // private Text householdName;
    private Sims sim;
    private final Wrapper<String> simName;
    // private HouseholdDetails householdDetails;

    public SimDetailsInformation(HouseholdData householdData, Wrapper<String> householdName, Wrapper<String> simName) {
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
        if (this.sim.getType().equals("Vampire")) {
            System.out.println("Thirst: " + this.sim.thirst);
        }
        System.out.println("Mood: " + this.sim.mood);
        System.out.println("+------------------------+");
        
        System.out.println("Skills:");
        if (this.sim.skills == null || this.sim.skills.isEmpty()) {
            System.out.println("No skills yet.");

        } else {
            for (Map.Entry<String, Skill> entry : this.sim.skills.entrySet()) {
                if (entry.getValue().getLevel() <= 0) {
                    continue;
                }

                System.out.println(" - " + entry.getKey() + " Skill (" + entry.getValue().getLevel() + "/10)");
            }
        }
        
        System.out.println("+------------------------+");

        System.out.println("Friends:");
        if (this.sim.friendIds == null || this.sim.friendIds.isEmpty()) {
            System.out.println("No friends yet.");
        } else {
            for (long friendId : this.sim.friendIds) {
                System.out.println(" - " + householdDetails.getSim(friendId).name + " (" + householdDetails.getSim(friendId).getFriendshipStatus() + ")");
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
