public class SquareState implements State {
    public double width = 10;

    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getCircumference() {
        return 4 * width;
    }
}
