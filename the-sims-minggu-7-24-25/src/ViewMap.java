
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
        if (householdDetails.shouldRandomize) {
            randomizeSimLoc();
            householdDetails.shouldRandomize = false;
        }

        // fills map with sims
        map.populateSimsMap();
        map.printMap();

        if (message.get() != null) {
            System.out.println(message.get());

            // resets message
            message.set(null);
        }

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
        return PageType.MAP;
    }

    // handles chars
    @Override
    public PageType handleInput(Object inp) {
        if (inp == null) {
            return PageType.MAP;
        }

        switch (Character.toUpperCase((char) inp)) {
            case 'W':
                handleMove(-1, 0);
                return PageType.MAP;
                
            case 'S':
                handleMove(1, 0);
                return PageType.MAP;

            case 'A':
                handleMove(0, -1);
                return PageType.MAP;

            case 'D':
                handleMove(0, 1);
                return PageType.MAP;

            case 'E':
                handleEat();
                return PageType.MAP;

            case 'M':
                handleDrink();
                return PageType.MAP;

            case 'I':
                return PageType.LEARN;
            
            case 'L':
                handleSleep();
                return PageType.MAP;

            case 'X':
                return PageType.MANAGE_HOUSEHOLD_INFORMATION;

            default:
                handleInvalid();
        }

        return PageType.MAP;
    }

    public void handleMove(int y, int x) {
        message.set("Moving Zuzu...");
        movePlayer(y, x);
        if (detectInteraction()) {
            handleInteraction();
        }
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
            player.hunger = Math.clamp(player.hunger + 20 + player.skills.get("Cooking").getLevel() * 2, 0, 50);
            player.mood = "Satisfied";

            message.set(player.name + " eats.\n" +
                        player.name + " now has a hunger level of " + player.hunger);

        } else if (type.equals("Vampire")) {
            player.thirst = Math.clamp(player.thirst - 20, 0, 50);
            player.hunger = Math.clamp(player.hunger + 20 + player.skills.get("Cooking").getLevel() * 2, 0, 50);
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
            player.energy = 50;

            message.set(player.name + " sleeps in a bed to recharge energy.");

        } else if (type.equals("Vampire")) {
            player.thirst = Math.clamp(player.thirst - 30, 0, 50);
            player.hunger = Math.clamp(player.hunger - 30, 0, 50);
            player.energy = 50;
            player.mood = "Rested";
            
            message.set(player.name + " sleeps in a coffin to recharge energy.");

        } else if (type.equals("Alien")) {
            player.hunger = Math.clamp(player.hunger - 30, 0, 50);
            player.mood = "Rested";
            player.energy = 50;
            
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

    public boolean detectInteraction() {
        for (int i = 0; i < householdDetails.getCount(); i++) {
            if (householdDetails.getSim(i).equals(player)) {
                continue;
            }

            if (!player.pos.equals(householdDetails.getSim(i).pos)) {
                continue;
            }

            other = householdDetails.getSim(i);
            return true;
        }

        return false;
    }

    public void handleInteraction() {
        if (player.getType().equals("Human") || player.getType().equals("Vampire")) {
            message.set(player.name + " interacts with " + other.name + " and feels Happy.");
            player.mood = "Happy";
            player.energy = Math.clamp(
                player.energy - 20 + (player.skills.get("Logic").getLevel() * 1), 
                0, 
                50);
        }

        else if (player.getType().equals("Alien")) {
            message.set(player.name + " interacts with " + other.name + " and feels Curious.\n" + player.name + " is ");
            
            String toAppend = "";
            if (other.getType().equals("Human")) {
                player.energy = Math.clamp(
                    player.energy - 30 + (player.skills.get("Logic").getLevel() * 1), 
                    0, 
                    50);
                player.mood = "Curious";
                toAppend = "curious about human behaviour.";
            }
            
            else if (other.getType().equals("Vampire")) {
                player.energy = Math.clamp(
                    player.energy - 20 + (player.skills.get("Logic").getLevel() * 1), 
                    0, 
                    50);
                player.mood = "Intrigued";
                toAppend = "intrigued by the vampire's abilities.";
            }
            
            else if (other.getType().equals("Alien")) {
                player.energy = Math.clamp(
                    player.energy - 10 + (player.skills.get("Logic").getLevel() * 1), 
                    0, 
                    50);
                player.mood = "Happy";
                toAppend = "happy to see another alien.";
            }

            message.set(message.get() + toAppend);
        }

        // adding and friendship points
        {
            long playerId = player.getId();
            long otherId = other.getId();

            Friendship friendship = householdDetails.getFriendship(playerId, otherId);
            if (friendship == null) {
                Friendship newFriendship = new Friendship(householdDetails);
                newFriendship.addFriend(playerId, otherId);
            } else {
                int amount = 10 + player.skills.get("Charisma").getLevel() * 2;
                friendship.addFriendshipPoint(playerId, otherId, amount);
            }
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
