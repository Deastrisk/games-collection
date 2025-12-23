

public class MainMenu {
    private Pages page = Pages.MAIN_MENU;
    private String title = "MENU";

    public void display() {
        System.out.println("+--------------+");
        System.out.println("| " + title);
        System.out.println("+--------------+");
        System.out.println("| 1. Square");
        System.out.println("| 2. Circle");
        System.out.println("| 3. Triangle");
        System.out.println("| 4. Hexagon");
        System.out.println("+--------------+");

        int page;
        while (true) { 
            System.out.print(">> ");
            if (!App.scanner.hasNextInt()) {
                continue;
            }

            page = App.scanner.nextInt();
            if (page >= 1 && page <= 4) {
                break;
            }
        }

        switch (page) {
            case 1:
                this.page = 
        }
    }
}
