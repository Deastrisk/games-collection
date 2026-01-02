
public class ViewMap implements Pages {
    private final HouseholdData householdData;
    private final Wrapper<String> householdName;
    private final Wrapper<String> simName;

    private Sims player;
    private Sims other;

    private Actions action;

    private String message = null;
    private HouseholdDetails householdDetails;
    private SimsMap map;

    private enum Actions {
        MOVE_UP,    // W
        MOVE_LEFT,  // A
        MOVE_DOWN,  // S
        MOVE_RIGHT, // D

        EAT,        // E
        DRINK,      // M
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

        randomizeSimLoc();

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
                             """ + 
                             (player.getType().equals("Vampire") ? "[M] - Drink\n" : "") +
                             """
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

            case 'M':
            case 'm':
                if (!player.getType().equals("Vampire")) {
                    break;
                }

                handleDrink();
                action = Actions.DRINK;
                return PageType.MAP;

            case 'I':
            case 'i':
                action = Actions.LEARN;
                return PageType.MAP;
            
            case 'L':
            case 'l':
                handleSleep();
                action = Actions.SLEEP;
                return PageType.MAP;

            case 'X':
            case 'x':
                action = Actions.EXIT;
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;

            default:
                handleInvalid();
        }

        return PageType.MAP;
    }

    public void handleInvalid() {
        message = null;
    }

    public moveRight() {
        message = "Moving " + player.name;
        
    }

    public void handleEat() {
        String type = player.getType();
        if (type.equals("Human") || type.equals("Alien")) {
            player.hunger = Math.clamp(player.hunger + 20, 0, 50);
            player.mood = "Satisfied";

            message = player.name + " eats.\n" +
                    player.name + " now has a hunger level of " + player.hunger;

        } else if (type.equals("Vampire")) {
            player.thirst = Math.clamp(player.thirst - 20, 0, 50);
            player.hunger = Math.clamp(player.hunger + 20, 0, 50);
            player.mood = "Thirsty";
            
            message = player.name + " eats and starts to feel thirsty.\n" + 
                    player.name + " now has a hunger level of " + player.hunger;
        }

    }

    public void handleSleep() {
        String type = player.getType();
        if (type.equals("Human")) {
            player.hunger = Math.clamp(player.hunger - 30, 0, 50);
            player.mood = "Rested";


            message = player.name + " sleeps in a bed to recharge energy.\n";

        } else if (type.equals("Vampire")) {
            player.thirst = Math.clamp(player.thirst - 30, 0, 50);
            player.hunger = Math.clamp(player.hunger - 30, 0, 50);
            player.mood = "Rested";

            
            message = player.name + " sleeps in a coffin to recharge energy.\n";

        } else if (type.equals("Alien")) {
            player.hunger = Math.clamp(player.hunger - 30, 0, 50);
            player.mood = "Rested";

            
            message = player.name + " sleeps in a spaceship to recharge energy.\n";
        }
    }

    public boolean handleDrink() {
        if (!player.getType().equals("Vampire")) {
            return false;
        }

        player.thirst = Math.clamp(player.thirst + 30, 0, 50);
        player.mood = "Satisfied";
        message = player.name + " drinks blood and now has a thirst level of " + player.thirst;

        return true;
    }

    public void randomizeSimLoc() {
        for (int i = 0; i < householdDetails.getCount();) {
            int x = (int) (Math.random() * map.width());
            int y = (int) (Math.random() * map.height());

            if (householdDetails.map.get(y, x) != ' ') {
                continue;
            }

            householdDetails.map.set(y, x, householdDetails.getSim(i).name.charAt(0));
            this.householdDetails.getSim(i).pos.set(y, x);
            i++;
        }
    }

    // public void detectInteraction() {
    //     if ()
    // }

    public void handleInteraction() {
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
