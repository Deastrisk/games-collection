
import java.util.HashMap;
import java.util.Map;

public class SimsData {
    private final Map<Long, Sims> allSims = new HashMap<>();
    private long latestId = 0;

    public Sims createSim(String name, int thirst) {
        return new Sims(name, latestId++, thirst);
    }

    public boolean addFriendshipPoint(int id, int amount) {
        
    }

    public Sims getSim(long id) {
        return allSims.get(id);
    }
}
