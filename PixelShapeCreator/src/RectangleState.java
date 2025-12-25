public class RectangleState implements State {
    public int width = 12;
    public int height = 8;

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getCircumference() {
        return 2 * (width + height);
    }
}
