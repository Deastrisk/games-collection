import java.util.*;

public class BankApp {
    static final Scanner scanner = new Scanner(System.in);
    private int page = -1;
    private static final List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BankApp app = new BankApp();
        int id = -1;

        while (true) {
            if (app.page == -1) app.mainMenu();
            else if (app.page == 0) return;
            else if (app.page == 1) app.createAccount();
            else if (app.page == 2) id = app.login();
            else if (app.page == 3) {
                // creates AccountPages object for account related pages
                AccountPages accPages = new AccountPages(accounts.get(id));

                // accPages for all the account related pages
                accPages.show();

                // accPages ends, switch back to main menu
                app.page = -1;
            }
        }
    }

    public int login() {
        System.out.println("===== BANK =====");
        if (accounts.isEmpty()) {
            System.out.println("No Accounts in Database.");
            page = -1;
            return -1;
        }

        System.out.print("Name     : ");
        String name = scanner.nextLine();

        System.out.print("ID       : ");
        int id = -1;
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ID Must be a number!");
            page = -1;
            return -1;
        } finally {
            scanner.nextLine();
        }

        System.out.print("Password : ");
        String pass = scanner.nextLine();

        if (accounts.getLast().getId() < id) {
            System.out.println("Invalid ID");
            page = -1;
            return -1;
        }

        if (name.compareTo(accounts.get(id).getName()) != 0 ||
            pass.compareTo(accounts.get(id).getPass()) != 0
        ) {
            System.out.println("Wrong id, username, or password.");
            page = -1;
            return -1;
        }

        page = 3;
        return id;
    }

    public void createAccount() {
        System.out.println("===== BANK =====");
        System.out.print("Input Name     : ");
        String name = scanner.nextLine();

        System.out.print("Input Password : ");
        String pass = scanner.nextLine();

        accounts.add(new Account(name, pass));

        System.out.println("Your id is " + accounts.getLast().getId());
        page = -1;
    }

    public void mainMenu() {
        System.out.println("===== BANK =====");
        System.out.println("1. Create Account");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        
        int inp;
        while (true) { 
            System.out.print(">> ");
            
            try {
                inp = scanner.nextInt();
            } catch (InputMismatchException e) {
                inp = -1;
                continue;
            } finally {
                scanner.nextLine();
            }

            if (inp >= 0 && inp <= 2) {
                break;
            }
        }

        page = inp;
    }
}
