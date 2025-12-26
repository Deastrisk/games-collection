import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class TriangleState implements State {
    public int a = 5;
    public int b = 5;
    public int base = 5;

    // ArrayList<ArrayList<Integer>> coordinates = List.of(

    // );
    ArrayList<ArrayList<Integer>> shape;

    public TriangleState() {
        // creates 2d array
        shape = new ArrayList<>();
        initializeShape();
    }

    public final double getHeight() {
        double s = (a + b + base) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - base)) * 2 / base;
    }

    @Override
    public double getArea() {
        return base * getHeight() / 2;
    }

    @Override
    public double getPerimeter() {
        return a + b + base;
    }

    // intializes shape ArrayList with 0's
    private void initializeShape() {
        for (int i = 0, height = (int) getHeight(); i < height; i++) {
            for (int j = 0; j < base; j++) {
                shape.get(i).add(0);
            }
        }
    }

    // private double getSlope(int x1, int x2, int y1, int y2) {
    //     return (y2 - y1) / (x2 - x1);
    // }

    // // private void bresenham(int x1, int x2, int y1, int y2) {
    // //     double m = getSlope(x1, x2, y1, y2);
    // //     double c = -m * x2;
    // //     for (int x = x1; x < x2; x++) {
    // //         int y = (int) Math.round(m * x + c);
    // //         shape.get(y).set(x, 1);
    // //     }
    // // }

    @Override
    public void printShape() {
        for (int i = 0, height = (int) getHeight(); i < height; i++) {
            for (int j = 0; j < base; j++) {
                System.out.printf("%2d", shape.get(i).get(j));
            }
            System.out.println();
        }
    }
}
