import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HouseholdDetails {
    private final Map<Long, Sims> sims = new HashMap<>();
    private long latestId = 0;
    public final SimsMap map;
    public boolean previouslyOpened = false;
    
    public HouseholdDetails() {
        this.map = new SimsMap(sims);
    }

    public Sims createVampire(String name) {
        Sims sim = new Vampire(name, latestId++);
        sims.put(latestId - 1, sim);
        return sim;
    }

    public Sims createHuman(String name) {
        Sims sim = new Human(name, latestId++);
        sims.put(latestId - 1, sim);
        return sim;
    }

    public Sims createAlien(String name) {
        Sims sim = new Alien(name, latestId++);
        sims.put(latestId - 1, sim);
        return sim;
    }

    public int getCount() {
        return sims.size();
    }

    public Sims getSim(long index) {
        Objects.requireNonNull(index);
        if (index < 0 || index >= latestId) {
            throw new IndexOutOfBoundsException(
                    "Cannot retrieve an invalid sim. (" + 
                    index + " < 0 || " + index + " >= " + latestId + ")"
            );
        }

        return sims.get(index);
    }

    public Sims getSim(String name) {
        Objects.requireNonNull(name);
        for (Sims sim : sims.values()) {
            if (sim.name.equals(name)) {
                return sim;
            }
        }
        return null;
    }
}
