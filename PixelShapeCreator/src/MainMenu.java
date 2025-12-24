public class MainMenu implements Menu {
    @Override
    public void display() {
        System.out.println("+---------------+");
        System.out.println("| MENU");
        System.out.println("+---------------+");
        System.out.println("| 1. Shapes");
        System.out.println("| 0. Exit");
        System.out.println("+---------------+");
    }

    @Override
    public MenuType handleInput(int input) {
        switch (input) {
            case 0: return MenuType.EXIT;
            case 1: return MenuType.SHAPES;
            default: return MenuType.MAIN;
        }
    }

    @Override
    public int getInput() {
        while (true) { 
            System.out.print("| >> ");

            // validates input
            if (!App.scanner.hasNextInt()) continue;
            int inp = App.scanner.nextInt();

            if (inp >= 0 && inp <= 1) return inp;
        }
    }
}
