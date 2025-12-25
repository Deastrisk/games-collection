import java.util.ArrayList;

public class TriangleState implements State {
    public int a = 5;
    public int b = 5;
    public int base = 5;

    ArrayList<ArrayList<Boolean>> shape;

    public TriangleState() {
        shape = new ArrayList<>();

        for (int i = 0; i < getHeight(); i++) {
            shape.add(new ArrayList<>());
        }
    }

    public int getHeight() {
        return (int) Math.ceil(Math.sqrt(a * a - base * base));
    }

    @Override
    public double getArea() {
        return base * getHeight() / 2;
    }

    @Override
    public double getPerimeter() {
        return a + b + base;
    }

    private void createShape() {
        return;
    }

    @Override
    public void printShape() {
        return;
    }
}
