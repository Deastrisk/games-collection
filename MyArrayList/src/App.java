import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(6);
        arr.add(4, 4);
        arr.add(5, 5);
        
        ListIterator<Integer> items = arr.listIterator();

        while (items.hasNext()) {
            System.out.println(items.next());
            if (items.nextIndex() == 3) {
                items.add(100);
            }
        }

        System.out.println();
        System.out.println();
        while (items.hasPrevious()) {
            System.out.println(items.previous());

            if (items.nextIndex() == 2) {
                items.add(123);
                if (!items.hasPrevious()) continue;
                items.previous();
            }
        }

        System.out.println();
        while (items.hasNext()) {
            System.out.println(items.next());
            if (items.nextIndex() == 3) {
                items.add(100);
            }
        }

        System.out.println("\n" + arr.size());

        System.out.println(arr.contains(5));
    }
}
