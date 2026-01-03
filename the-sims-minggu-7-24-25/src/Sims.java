import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Sims {
    protected String name;
    protected String mood = "Fine";
    protected int hunger = 50;
    protected int energy = 50;
    protected int thirst;
    public Coordinate pos;

    public Sims(String name, int thirst) {
        this.name = name;
        this.thirst = thirst;

        pos = new Coordinate(-1, -1);
    }

    public abstract String getType();

    protected Map<String, Skill> skills = Map.of(
        "Cooking", new Cooking(),
        "Logic", new Logic(),
        "Charisma", new Charisma()
    );
    protected List<Friend> friends = new ArrayList<>();
}
