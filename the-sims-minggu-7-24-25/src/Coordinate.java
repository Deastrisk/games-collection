public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || !(other instanceof Coordinate)) return false;
        Coordinate comp = (Coordinate) other;
        return (comp.x() == this.x && comp.y() == this.y);
    }

    @Override
    public final int hashCode() {
        int result = 1;
        int prime = 31;
        
        /*
        * This method was written by Doug Lea with assistance from members of JCP
        * JSR-166 Expert Group and released to the public domain, as explained at
        * http://creativecommons.org/licenses/publicdomain
        * 
        * As of 2010/06/11, this method is identical to the (package private) hash
        * method in OpenJDK 7's java.util.HashMap class.
        */

        // the method was then adapted by me (Marcio)
        // hashes using the method above
        int intHash = x ^ ((x >>> 20) ^ (x >>> 12));
        intHash = intHash ^ (intHash >>> 7) ^ (intHash >>> 4);

        // adds the hash result to prime
        result = prime * result + intHash;

        intHash = y ^ ((y >>> 20) ^ (y >>> 12));
        intHash = intHash ^ (intHash >>> 7) ^ (intHash >>> 4);

        result = prime * result + intHash;
        return result;
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
