import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HouseholdDetails {
    private int count = 0;
    private final List<Sims> simsList;
    public final SimsMap map;

    public HouseholdDetails() {
        this.simsList = new ArrayList<>();
        this.map = new SimsMap(simsList);
    }

    public int getCount() {
        return count;
    }

    public int incrementCount() {
        return ++this.count;
    }

    public int reduceCount() {
        return --this.count;
    }

    public Sims getSim(int index) {
        Objects.requireNonNull(index);
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        return simsList.get(index);
    }

    public Sims getSim(String name) {
        Objects.requireNonNull(name);
        for (Sims sim : simsList) {
            if (sim.name.equals(name)) {
                return sim;
            }
        }
        return null;
    }

    public void addSims(Sims sim) {
        simsList.add(sim);
        count++;
    }
}
