import java.util.ArrayList;
import java.util.List;

public class SimsMap {
    private final List<List<Character>> map;
    private final int defaultXSize = 13;
    private final int defaultYSize = 5;

    public SimsMap() {
        map = new ArrayList<>(defaultYSize);

        for (int i = 0; i < defaultYSize; i++) {
            List<Character> row = new ArrayList<>(defaultXSize);

            for (int j = 0; j < defaultXSize; j++) {
                row.add(' ');
            }

            map.add(row);
        }
    }

    public int height() {
        return defaultYSize;
    }

    public int width() {
        return defaultXSize;
    }

    public void clear() {
        for (List<Character> row : map) {
            for (Character c : row) {
                c = ' ';
            }
        }
    }

    public char get(int y, int x) {
        if (x < 0 || x >= defaultXSize || y < 0 || y >= defaultYSize) {
            throw new IndexOutOfBoundsException();
        }

        return map.get(y).get(x);
    }

    public void set(int y, int x, char c) {
        if (x < 0 || x >= defaultXSize || y < 0 || y >= defaultYSize) {
            throw new IndexOutOfBoundsException();
        }

        map.get(y).set(x, c);
    }
}
