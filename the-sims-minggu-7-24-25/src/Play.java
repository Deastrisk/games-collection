public class Play {
    private int page = -1;

    public void display() {
        System.out.println("+==================== SIMS ====================+");
        System.out.println("| Name                | Type    | Mood         |");
        System.out.println("+---------------------+---------+--------------+");

        Sims.printSimsList();

        System.out.println("+==============================================+");
        System.out.println("| 1. Create a Sim                              |");
        System.out.println("| 2. Manage Sim                                |");
        System.out.println("| 3. Exit Game                                 |");
        System.out.println("+==============================================+");
        while (true) { 
            int inp = Game.scanner.nextInt();
            if (inp >= 1 && inp <= 3) {
                this.page = inp;
                break;
            }
            System.out.println("Invalid option");
        }
    }   
}
