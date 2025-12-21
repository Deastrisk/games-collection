import java.util.Scanner;

public class Game {
    private int page = 0;
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        while (true) { 
            switch (game.page) {
                case 0: game.menu(); break;
                case 1: Play.display(); break;
                case 2: return;
            }
        }
    }

    private void menu() {
        System.out.println("+=============+");
        System.out.println("|   The Sims  |");
        System.out.println("+=============+");
        System.out.println("| 1. Play     |");
        System.out.println("| 2. Exit     |");
        System.out.println("+=============+");
        System.out.print(">> ");
        
        int inp = -1;
        while (true) {
            inp = scanner.nextInt();
            if (inp <= 2 && inp >= 0) {
                this.page = inp;
                break;
            }
            else System.out.println("Invalid input");
        }
    }
}
