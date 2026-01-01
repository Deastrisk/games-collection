public class ViewMap implements Pages {
    private final HouseholdData householdData;
    private final Wrapper<String> householdName;
    private final Wrapper<String> simName;

    private Sims player;
    private Sims other;

    private Actions action = Actions.INVALID;

    private String message = null;

    private enum Actions {
        MOVE_UP,    // W
        MOVE_LEFT,  // A
        MOVE_DOWN,  // S
        MOVE_RIGHT, // D

        EAT,        // E
        SLEEP,      // L
        LEARN,      // I
        EXIT,       // X

        INVALID     // pressed a key which doesn't exists
    }

    public ViewMap(HouseholdData householdData, Wrapper<String> householdName, Wrapper<String> selectedSimName) {
        this.householdData = householdData;
        this.householdName = householdName;
        this.simName = selectedSimName;
    }

    @Override
    public PageType IODisplay() {
        HouseholdDetails householdDetails = householdData.details.get(householdName.get());
        player = householdDetails.getSim(simName.get());
        SimsMap map = householdDetails.map;

        while (true) {
            // 13
            System.out.print("+");
            for (int i = 0; i < map.width(); i++) {
                System.out.print("-");
            }
            System.out.println("+");

            for (int i = 0; i < map.height(); i++) {
                System.out.print("|");
                for (int j = 0; j < map.width(); j++) {
                    System.out.print(map.get(i, j));
                }
                System.out.println("|");
            }

            System.out.print("+");
            for (int i = 0; i < map.width(); i++) {
                System.out.print("-");
            }
            System.out.println("+");

            if (message != null)
                System.out.println(message);

            System.out.print("[WASD] - Move Sim\n" +
                             "[E] - Eat\n" +
                             "[L] - Sleep\n" + 
                             "[I] - Learn new skill\n" +
                             "[X] - Exit view map\n");

            char inp = getInput();
            if (handleInput(inp) == PageType.MANAGE_HOUSEHOLD_INFORMATION) {
                return PageType.CREATE_SIM_HOUSEHOLD;
            };
        }   
    }

    // handles chars
    @Override
    public PageType handleInput(Object inp) {
        switch ((char) inp) {
            case 'W':
            case 'w':
                message = "Moving Zuzu...";
                action = Actions.MOVE_UP;
                return PageType.MAP;
                
            case 'S':
            case 's':
                message = "Moving Zuzu...";
                action = Actions.MOVE_DOWN;
                return PageType.MAP;

            case 'A':
            case 'a':
                message = "Moving Zuzu...";
                action = Actions.MOVE_LEFT;
                return PageType.MAP;

            case 'D':
            case 'd':
                message = "Moving Zuzu...";
                action = Actions.MOVE_RIGHT;
                return PageType.MAP;

            case 'E':
            case 'e':
                handleInteraction();
                action = Actions.EAT;
                return PageType.MAP;

            case 'I':
            case 'i':
                action = Actions.LEARN;
                return PageType.MAP;
            
            case 'L':
            case 'l':
                action = Actions.SLEEP;
                return PageType.MAP;

            case 'X':
            case 'x':
                action = Actions.EXIT;
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;

            default: return PageType.MAP;
        }
    }

    public void handleInteraction() {
        if (other == null) {
            message = ""
            return;
        }

        if (player.getType().equals("Human") || player.getType().equals("Vampire")) {
            message = player.name + " interacts with " + other.name + " and feels Happy.";
            player.mood = "Happy";
            player.energy -= 20;
        }

        else if (player.getType().equals("Alien")) {
            message = player.name + " interacts with " + other.name + " and feels Curious.\n" + player.name + " is ";
            
            String toAppend = "";
            if (other.getType().equals("Human")) {
                player.energy -= 30;
                player.mood = "Curious";
                toAppend = "curious about human behaviour.";
            }
            
            else if (other.getType().equals("Vampire")) {
                player.energy -= 20;
                player.mood = "Intrigued";
                toAppend = "intrigued by the vampire's abilities.";
            }
            
            else if (other.getType().equals("Alien")) {
                player.energy -= 10;
                player.mood = "Happy";
                toAppend = "happy to see another alien.";
            }

            message += toAppend;
        }
    }

    @Override
    public Character getInput() {
        String inpStr = App.scanner.nextLine();
        if (inpStr == null || inpStr.isEmpty()) {
            return null;
        }

        return inpStr.charAt(0);
    }
}
