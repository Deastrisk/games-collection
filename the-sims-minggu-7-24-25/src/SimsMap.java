import java.util.Arrays;
import java.util.Map;

public class SimsMap {
    private final char[] map;
    // this was originally 2d but FOR SOME DUMB REASON I changed it to 1d :")
    // absolute stupidity bruh
    // well it was bcs i heard somewhere that a 1d array is better than a 2d one
    // but thinking again that was kind of stupid...
    private final char[] simsMap;
    public Map<Long, Sims> simsList;
    private final int defaultXSize = 13;
    private final int defaultYSize = 5;

    public SimsMap(Map<Long, Sims> simsList) {
        map = new char[defaultXSize * defaultYSize];
        simsMap = new char[defaultXSize * defaultYSize];
        Arrays.fill(map, ' ');
        Arrays.fill(simsMap, ' ');

        this.simsList = simsList;
    }

    public void populateSimsMap() {
        clearSimsMap();
        for (Sims sim : simsList.values()) {
            int x = sim.pos.x();
            int y = sim.pos.y();

            this.setSimsMap(y, x, sim.name.charAt(0));
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
                if (this.getSimsMap(i, j) != ' ') {
                    System.out.print(this.getSimsMap(i, j));
                } else {
                    System.out.print(this.get(i, j));
                }
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

    public void clearSimsMap() {
        Arrays.fill(simsMap, ' ');
    }

    public char get(int y, int x) {
        if (x < 0 || x >= defaultXSize || y < 0 || y >= defaultYSize) {
            throw new IndexOutOfBoundsException();
        }

        return map[y * defaultXSize + x];
    }

    public char getSimsMap(int y, int x) {
        if (x < 0 || x >= defaultXSize || y < 0 || y >= defaultYSize) {
            throw new IndexOutOfBoundsException();
        }

        return simsMap[y * defaultXSize + x];
    }

    public void set(int y, int x, char c) {
        if (x < 0 || x >= defaultXSize || y < 0 || y >= defaultYSize) {
            throw new IndexOutOfBoundsException(x + ", " + y);
        }

        map[y * defaultXSize + x] = c;
    }

    public void setSimsMap(int y, int x, char c) {
        if (x < 0 || x >= defaultXSize || y < 0 || y >= defaultYSize) {
            throw new IndexOutOfBoundsException(x + ", " + y);
        }

        simsMap[y * defaultXSize + x] = c;
    }
}
