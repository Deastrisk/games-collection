public class RectangleState implements State {
    public int width = 12;
    public int height = 8;

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void printShape() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("##");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
