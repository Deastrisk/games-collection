public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public boolean move(int yDis, int xDis, int width, int height) {
        int newX = this.x + xDis;
        int newY = this.y + yDis;

        if (newX < 0 || newY < 0 || newX >= width || newY >= height) {
            return false;
        }
        
        this.set(newY, newX);
        return true;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
}
