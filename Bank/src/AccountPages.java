import java.util.InputMismatchException;

class AccountPages {
    private int currentId;
    private Account account;
    private int page;

    public AccountPages(Account acc) {
        account = acc;
    }

    public void show() {
        while (true) { 
            if (page == -1) return;
            else if (page == 0) accountMenu();
            else if (page == 1) withdrawPage();
            else if (page == 2) depositPage();
            else if (page == 3) accountInformation();
        }
    }
    
    public final void accountInformation() {
        System.out.println("===== " + account.getName() + " =====");
        System.out.println("Full Name : " + account.getName());
        System.out.println("Password  : " + account.getPass());
        System.out.println("ID        : " + account.getId());
        System.out.println("Balance   : Rp" + account.getBalance());
        page = 0;
    }

    public final void depositPage() {
        System.out.println("===== " + account.getName() + " =====");
        System.out.print("Deposit amount : ");

        double amount = 0;
        try {
            amount = BankApp.scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Amount must a number!");
            return;
        } finally {
            BankApp.scanner.nextLine();
        }

        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit unsuccessful.");
        }
        page = 0;
    }

    public final void withdrawPage() {
        System.out.println("===== " + account.getName() + " =====");
        System.out.print("Withdraw amount : ");

        double amount = 0;
        try {
            amount = BankApp.scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Amount must a number!");
            return;
        } finally {
            BankApp.scanner.nextLine();
        }

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal unsuccessful.");
        }
        page = 0;
    }

    public final void accountMenu() {
        System.out.println("===== " + account.getName() + " =====");
        System.out.println("1. Account Information");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("0. Back to Menu");
        
        int inp;
        while (true) { 
            System.out.print(">> ");
            try {
                inp = BankApp.scanner.nextInt();
            } catch (InputMismatchException e) {
                continue;
            } finally {
                BankApp.scanner.nextLine();
            }

            if (inp >= 0 && inp <= 3) {
                switch (inp) {
                    case 0:
                        page = -1;
                        currentId = -1;
                        break;
                    case 1:
                        page = 3;
                        break;
                    case 2:
                        page = 1;
                        break;
                    case 3:
                        page = 2;
                        break;
                }
                break;
            }
        }
    }
}