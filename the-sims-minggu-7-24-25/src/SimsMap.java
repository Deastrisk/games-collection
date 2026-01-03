import java.util.Arrays;
import java.util.List;

public class SimsMap {
    private final char[] map;
    public List<Sims> simsList;
    private final int defaultXSize = 13;
    private final int defaultYSize = 5;

    public SimsMap(List<Sims> simsList) {
        map = new char[defaultXSize * defaultYSize];
        Arrays.fill(map, ' ');

        this.simsList = simsList;
    }

    public void populateMap() {
        for (Sims sim : simsList) {
            int x = sim.pos.x();
            int y = sim.pos.y();

            this.set(y, x, sim.name.charAt(0));
        }
    }

    public void printMap() {
        System.out.print("+");
        for (int i = 0; i < this.width(); i++) {
            System.out.print("-");
        }
        System.out.println("+");

        for (int i = 0; i < this.height(); i++) {
            System.out.print("|");

            for (int j = 0; j < this.width(); j++) {
                System.out.print(this.get(i, j));
            }

            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < this.width(); i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    public int height() {
        return defaultYSize;
    }

    public int width() {
        return defaultXSize;
    }

    public void clear() {
        Arrays.fill(map, ' ');

        // clears sim position
        for (int i = 0; i < simsList.size(); i++) {
            simsList.get(i).pos.set(-1, -1);
        }
    }

    public char get(int y, int x) {
        if (x < 0 || x >= defaultXSize || y < 0 || y >= defaultYSize) {
            throw new IndexOutOfBoundsException();
        }

        return map[y * defaultXSize + x];
    }

    public void set(int y, int x, char c) {
        if (x < 0 || x >= defaultXSize || y < 0 || y >= defaultYSize) {
            throw new IndexOutOfBoundsException(x + ", " + y);
        }

        map[y * defaultXSize + x] = c;
    }
}
