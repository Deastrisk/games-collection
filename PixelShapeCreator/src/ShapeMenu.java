public class ShapeMenu implements Menu {
    @Override
    public void display() {
        System.out.println("+---------------+");
        System.out.println("| SELECT SHAPE");
        System.out.println("+---------------+");
        System.out.println("| 1. Square");
        System.out.println("| 2. Rectangle");
        System.out.println("| 3. Circle");
        System.out.println("| 4. Triangle");
        System.out.println("| 0. Back to Menu");
        System.out.println("+---------------+");
    }

    @Override
    public MenuType handleInput(int input) {
        switch (input) {
            case 1: return MenuType.SQUARE;
            case 2: return MenuType.RECTANGLE;
            case 3: return MenuType.CIRCLE;
            case 4: return MenuType.TRIANGLE;
            default: return MenuType.SHAPES;
        }
    }

    @Override
    public int getInput() {
        while (true) { 
            System.out.print("| >> ");

            if (!App.scanner.hasNextInt()) continue;
            int inp = App.scanner.nextInt();

            if (inp >= 0 && inp <= 4) return inp;
        }
    }
}
