import java.util.ArrayList;
import java.util.List;

public abstract class Sims {
    static List<String[]> simsList = new ArrayList<>();
    public static void printSimsList() {
        if (simsList == null || simsList.isEmpty()) {
            System.out.println("| No sims available.                           |");
        } else {
            System.out.println("+---------------------+---------+--------------+");
            for (String[] data : simsList) {
                System.out.printf("| %-19s | %-7s | %-12s |\n", data[0], data[1], data[2]);
            }
        }
    }
}
