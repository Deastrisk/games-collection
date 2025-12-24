public class SquareMenu implements Menu {
    private double width = 10;
    private double area = width * width;
    private double circumference = 4 * width;

    @Override
    public void display() {
        System.out.println("==== SQUARE ===");
        System.out.println("Width         : " + width);
        System.out.println("Area          : " + area);
        System.out.println("Circumference : " + circumference);
        System.out.println("===============");
        System.out.println("1. Settings");
        System.out.println("0. Exit");
        System.out.println("===============");
        printShape();
    }

    private void printShape() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("##");
            }
            System.out.println();
        }
    }

    @Override
    public MenuType handleInput(int input) {
        switch (input) {
            case 1: return MenuType.SQUARE_SETTINGS;
            case 0: return MenuType.SHAPES;
        }
    }

    @Override
    public int getInput() {
        while (true) { 
            System.out.print(">> ");

            if (!App.scanner.hasNextInt()) continue;
            int inp = App.nextInt();

            if (inp >= 0 && inp <= 1) return inp;
        }
    }
}
