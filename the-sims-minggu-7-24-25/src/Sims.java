import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Sims {
    private final long id;
    protected String name;
    protected String mood = "Fine";
    protected int hunger = 50;
    protected int energy = 50;
    protected int thirst;

    public Coordinate pos;

    public Set<Long> friendIds = new HashSet<>();
    protected Map<String, Skill> skills = Map.of(
        "Cooking", new Cooking(),
        "Logic", new Logic(),
        "Charisma", new Charisma()
    );

    public Sims(String name, long id,  Integer thirst) {
        this.name = name;
        if (thirst != null) this.thirst = thirst;
        this.id = id;
        pos = new Coordinate(-1, -1);
    }

    public abstract String getType();


    public Set<Long> getFriendIds() {
        return friendIds;
    }

    // public void addFriend(Sims sim) {
    //     this.friendIds.add(sim.id);
    // }

    public void addFriend(long id) {
        this.friendIds.add(id);
    }

    public long getId() {return this.id;}
}
