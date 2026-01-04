
public class ViewMap implements Pages {
    private final HouseholdData householdData;
    private final Wrapper<String> householdName;
    private final Wrapper<String> simName;

    private Sims player;
    private Sims other;

    private Wrapper<String> message = null;
    private HouseholdDetails householdDetails;
    private SimsMap map;

    public ViewMap(
        HouseholdData householdData, Wrapper<String> householdName, 
        Wrapper<String> selectedSimName, 
        Wrapper<String> message
    ) {
        message.set(null);
        this.message = message;
        this.householdData = householdData;
        this.householdName = householdName;
        this.simName = selectedSimName;
    }

    @Override
    public PageType IODisplay() {
        householdDetails = householdData.details.get(householdName.get());
        player = householdDetails.getSim(simName.get());
        map = householdDetails.map;

        // randomizes only the first time map is opened
        if (!householdDetails.previouslyOpened) {
            randomizeSimLoc();
            householdDetails.previouslyOpened = true;
        }

        // map loop
        while (true) {
            map.populateSimsMap();
            map.printMap();

            if (message.get() != null)
                System.out.println(message.get());

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

            Character inp = getInput();
            PageType nextPage = handleInput(inp);
            if (nextPage == PageType.MANAGE_HOUSEHOLD_INFORMATION) {
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;
            }

            else if (nextPage == PageType.LEARN) {
                return PageType.LEARN;
            }
        }   
    }

    // handles chars
    @Override
    public PageType handleInput(Object inp) {
        if (inp == null) {
            return PageType.MAP;
        }

        switch ((char) inp) {
            case 'W':
            case 'w':
                message.set("Moving Zuzu...");
                movePlayer(-1, 0);
                return PageType.MAP;
                
            case 'S':
            case 's':
                message.set("Moving Zuzu...");
                movePlayer(1, 0);
                return PageType.MAP;

            case 'A':
            case 'a':
                message.set("Moving Zuzu...");
                movePlayer(0, -1);
                return PageType.MAP;

            case 'D':
            case 'd':
                message.set("Moving Zuzu...");
                movePlayer(0, 1);
                return PageType.MAP;

            case 'E':
            case 'e':
                handleEat();
                return PageType.MAP;

            case 'M':
            case 'm':
                handleDrink();
                return PageType.MAP;

            case 'I':
            case 'i':
                handleLearn();
                return PageType.LEARN;
            
            case 'L':
            case 'l':
                handleSleep();
                return PageType.MAP;

            case 'X':
            case 'x':
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;

            default:
                handleInvalid();
        }

        return PageType.MAP;
    }
    
    public void handleLearn() {
        
        
    }

    public void handleInvalid() {
        message.set(null);
    }

    public void movePlayer(int y, int x) {
        message.set("Moving " + player.name + "...");
        // System.out.println(player.pos.x() + ", " + player.pos.y());
        player.pos.move(y, x, map.width(), map.height());
    }

    public void handleEat() {
        String type = player.getType();
        if (type.equals("Human") || type.equals("Alien")) {
            player.hunger = Math.clamp(player.hunger + 20, 0, 50);
            player.mood = "Satisfied";

            message.set(player.name + " eats.\n" +
                    player.name + " now has a hunger level of " + player.hunger);

        } else if (type.equals("Vampire")) {
            player.thirst = Math.clamp(player.thirst - 20, 0, 50);
            player.hunger = Math.clamp(player.hunger + 20, 0, 50);
            player.mood = "Thirsty";
            
            message.set(player.name + " eats and starts to feel thirsty.\n" + 
                    player.name + " now has a hunger level of " + player.hunger);
        }

    }

    public void handleSleep() {
        String type = player.getType();
        if (type.equals("Human")) {
            player.hunger = Math.clamp(player.hunger - 30, 0, 50);
            player.mood = "Rested";


            message.set(player.name + " sleeps in a bed to recharge energy.");

        } else if (type.equals("Vampire")) {
            player.thirst = Math.clamp(player.thirst - 30, 0, 50);
            player.hunger = Math.clamp(player.hunger - 30, 0, 50);
            player.mood = "Rested";

            
            message.set(player.name + " sleeps in a coffin to recharge energy.");

        } else if (type.equals("Alien")) {
            player.hunger = Math.clamp(player.hunger - 30, 0, 50);
            player.mood = "Rested";

            
            message.set(player.name + " sleeps in a spaceship to recharge energy.");
        }
    }

    public boolean handleDrink() {
        if (!player.getType().equals("Vampire")) {
            return false;
        }

        player.thirst = Math.clamp(player.thirst + 30, 0, 50);
        player.mood = "Satisfied";
        message.set(player.name + " drinks blood and now has a thirst level of " + player.thirst);

        return true;
    }

    public void randomizeSimLoc() {
        for (int i = 0; i < householdDetails.getCount();) {
            int x = (int) (Math.random() * map.width());
            int y = (int) (Math.random() * map.height());

            if (householdDetails.map.get(y, x) != ' ') {
                continue;
            }

            // householdDetails.map.set(y, x, householdDetails.getSim(i).name.charAt(0));
            this.householdDetails.getSim(i).pos.set(y, x);
            i++;
        }
    }

    // public void detectInteraction() {
    //     if ()
    // }

    public void handleInteraction() {
        if (player.getType().equals("Human") || player.getType().equals("Vampire")) {
            message.set(player.name + " interacts with " + other.name + " and feels Happy.");
            player.mood = "Happy";
            player.energy -= 20;
        }

        else if (player.getType().equals("Alien")) {
            message.set(player.name + " interacts with " + other.name + " and feels Curious.\n" + player.name + " is ");
            
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

            message.set(message.get() + toAppend);
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
