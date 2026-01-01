public class ViewMap implements Pages {
    private final HouseholdData householdData;
    private final Wrapper<String> householdName;
    private final Wrapper<String> simName;

    private Sims player;
    private Sims other;

    private Actions action = Actions.INVALID;

    private String message = null;
    private HouseholdDetails householdDetails;
    private SimsMap map;

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
        householdDetails = householdData.details.get(householdName.get());
        player = householdDetails.getSim(simName.get());
        map = householdDetails.map;

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

            System.out.print("""
                            [WASD] - Move Sim
                            [E] - Eat
                            [L] - Sleep
                            [I] - Learn new skill
                            [X] - Exit view map
                             """);

            char inp = getInput();
            if (handleInput(inp) == PageType.MANAGE_HOUSEHOLD_INFORMATION) {
                householdDetails.map.clear();
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;
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
                handleEat();
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

    public void handleEat() {
        String type = player.getType();
        if (type.equals("Human") || type.equals("Alien")) {
            player.hunger += 20;
            player.mood = "Satisfied";
            if (player.hunger > 50) player.hunger = 50;

            message = player.name + " eats.\n" +
                    player.name + " now has a hunger level of " + player.hunger;

        } else if (type.equals("Vampire")) {
            player.thirst -= 20;
            player.hunger += 20;
            if (player.thirst < 0 && type.equals("Vampire")) player.thirst = 0;
            if (player.hunger > 50) player.hunger = 50;
            
            message = player.name + " eats and starts to feel thirsty.\n" + 
                    player.name + " now has a hunger level of " + player.hunger;
        }

    }

    // males buat class baru bilek
    public void distantInteraction() {
        System.out.println("Chooose a Sim to interact with:");
        if (householdDetails.getCount() == 0) {
            System.out.println("No other Sims to interact with.");
            // System.out.print(">> ");

            App.scanner.nextLine();
            return;
        }

        for (int i = 0; i < householdDetails.getCount(); i++) {
            System.out.println((i + 1) + ". " + householdDetails.getSim(i).name);
        }

        int inp = chooseSim();
    }

    public void randomizeSimLoc() {
        for (int i = 0; i < householdDetails.getCount();) {
            int x = (int) (Math.random() * map.width());
            int y = (int) (Math.random() * map.height());

            if (householdDetails.map.get(y, x) != ' ') {
                continue;
            }

            householdDetails.map.set(y, x, householdDetails.getSim(i).name.charAt(0));
            i++;
        }
    }

    public int chooseSim() {
        while (true) { 
            System.out.print(">> ");
            String inpStr = App.scanner.nextLine();

            try {
                int inp = Integer.parseInt(inpStr);
                if (inp < 0 || inp > householdDetails.getCount()) {
                    System.out.println("Must select one of the Sims.");
                    continue;
                }
                return inp;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number.");
            }
        }
    }

    public void handleInteraction() {
        if (other == null) {
            distantInteraction();
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
