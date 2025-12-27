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

        arr.remove(3);

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

        System.out.println("\n" + arr.size());

        System.out.println(arr.contains(5));
    }
}
