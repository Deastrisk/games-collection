public class ViewMap implements Pages {
    private final HouseholdData householdData;
    private final Text householdName;
    private final Text simName;

    private Sims player;
    private Sims other;

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

    public ViewMap(HouseholdData householdData, Text householdName, Text selectedSimName) {
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
            if (handleInput(inp) == Actions.EXIT) {
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;
            }
        }   
    }

    // handles chars
    @Override
    public Actions handleInput(Object inp) {
        switch ((char) inp) {
            case 'W':
            case 'w':
                message = "Moving Zuzu...";
                return Actions.MOVE_UP;
                
            case 'S':
            case 's':
                message = "Moving Zuzu...";
                return Actions.MOVE_DOWN;

            case 'A':
            case 'a':
                message = "Moving Zuzu...";
                return Actions.MOVE_LEFT;

            case 'D':
            case 'd':
                message = "Moving Zuzu...";
                return Actions.MOVE_RIGHT;

            case 'E':
            case 'e':
                handleInteraction(player, other);
                return Actions.EAT;

            case 'I':
            case 'i':
                return Actions.LEARN;
            
            case 'L':
            case 'l':
                return Actions.SLEEP;

            case 'X':
            case 'x':
                return Actions.EXIT;
        }
    }

    public void handleInteraction() {
        if (player.getType() == "Human" || player.getType() == "Vampire") {
            message = player.name + " interacts with " + other.name + " and feels Happy.";
            player.mood = "Happy";
            player.energy -= 20;
        }

        else if (player.getType() == "Alien") {
            message = player.name + " interacts with " + other.name + " and feels Curious.\n" + player.name + " is ";
            
            String toAppend = "";
            if (other.getType() == "Human") {
                player.energy -= 30;
                player.mood = "Curious";
                toAppend = "curious about human behaviour.";
            }
            
            else if (other.getType() == "Vampire") {
                player.energy -= 20;
                player.mood = "Intrigued";
                toAppend = "intrigued by the vampire's abilities.";
            }
            
            else if (other.getType() == "Alien") {
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
