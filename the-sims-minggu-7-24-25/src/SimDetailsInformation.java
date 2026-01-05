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

        {
            boolean hasSkill = false;
            for (Map.Entry<String, Skill> entry : this.sim.skills.entrySet()) {
                if (entry.getValue().getLevel() <= 0) {
                    continue;
                }

                hasSkill = true;
                System.out.println(" - " + entry.getKey() + " Skill (" + entry.getValue().getLevel() + "/10)");
            }

            if (!hasSkill) {
                System.out.println("No skills yet.");
            }
        }
        
        System.out.println("+------------------------+");

        System.out.println("Friends:");
        {
            boolean hasFriend = false;
            for (long friendId : this.sim.friendIds) {
                System.out.println(" - " + householdDetails.getSim(friendId).name + " (" + householdDetails.getFriendship(this.sim.getId(), friendId).getFriendshipStatus() + ")");
                hasFriend = true;
            }

            if (!hasFriend) {
                System.out.println("No friends yet.");
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
