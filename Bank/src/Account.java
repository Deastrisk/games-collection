import java.util.*;

public class Account {
    private static final List<Integer> idList = new ArrayList<>();

    private final String name;
    private final String pass;
    private final int id;
    private double balance;

    public Account(String name, String pass) {
        this.name = name;
        this.pass = pass;
        this.balance = 0;

        if (idList.isEmpty()) {
            this.id = 0;
        } else {
            this.id = idList.get(idList.size() - 1) + 1;
        }
        idList.add(this.id);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public boolean deposit(double cash) {
        if (cash < 0) {
            System.out.println("Cannot deposit negative cash.");
            return false;
        }
        balance += cash;
        return true;
    }

    public boolean withdraw(double cash) {
        if (balance - cash < 0) {
            System.out.println("Cannot withdraw more than balance.");
            return false;
        }
        balance -= cash;
        return true;
    }
}
