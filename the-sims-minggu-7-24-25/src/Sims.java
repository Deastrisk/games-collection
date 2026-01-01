import java.util.ArrayList;
import java.util.List;

public abstract class Sims {
    protected String name;
    protected String mood = "Fine";
    protected int hunger = 50;
    protected int energy = 50;
    protected int thirst;

    public Sims(String name, int thirst) {
        this.name = name;
        this.thirst = thirst;
    }

    public abstract String getType();

    protected List<Skill> skills = new ArrayList<>();
    protected List<Friend> friends = new ArrayList<>();
}
