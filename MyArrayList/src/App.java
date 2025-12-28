import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(6);
        arr.add(4, 4);
        arr.add(5, 5);
        arr.add(2);

        // OTHER METHODS CHECK
        // System.out.println(arr.indexOf(2));
        // System.out.println(arr.lastIndexOf(2));

        MyArrayList<String> test = new MyArrayList<>();
        MyArrayList<String> test2 = new MyArrayList<>();
        test2.add("Hello");
        test2.add("world");

        test.add("this");
        test.add("is");
        test.add("java!");

        test.addAll(0, test2);
        // for (String string : test) {
        //     System.out.println(string);
        // }

        List<String> sub = test.subList(0, 3);
        // System.out.println(sub.size());
        // for (String text : sub) {
        //     System.out.println(text);
        // }

        // toArray TEST
        // Integer[] array = arr.toArray(new Integer[0]);
        // for (Integer i : array) {
        //     System.out.println(i);
        // }
        
        // ITERATOR TEST
        // ListIterator<Integer> items = arr.listIterator();

        // while (items.hasNext()) {
        //     System.out.println(items.next());
        //     if (items.nextIndex() == 3) {
        //         items.add(100);
        //     }
        // }

        // System.out.println();
        // System.out.println();
        // while (items.hasPrevious()) {
        //     System.out.println(items.previous());

        //     if (items.nextIndex() == 2) {
        //         items.add(123);
        //         if (!items.hasPrevious()) continue;
        //         items.previous();
        //     }
        // }

        // System.out.println();
        // while (items.hasNext()) {
        //     System.out.println(items.next());
        //     if (items.nextIndex() == 3) {
        //         items.add(100);
        //     }
        // }

        System.out.println("\n" + arr.size());
    }
}
