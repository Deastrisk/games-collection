

public class SimpleCalculator {
    double result = 0;
    String input = "";
    public static final double PI = 3.14159265;

    public static void main(String[] args) throws Exception {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.display();
    }

    private void display() {
        System.out.println("=== simple calculator ===");
        System.out.println("Input  : " + input);
        System.out.println("Result : " + result);
        System.out.println("[ ( ] [ ) ] [ AC] [DEL]");
        System.out.println("[ 9 ] [ 8 ] [ 7 ] [ + ]");
        System.out.println("[ 6 ] [ 5 ] [ 4 ] [ - ]");
        System.out.println("[ 3 ] [ 2 ] [ 1 ] [ * ]");
        System.out.println("[ 0 ] [ 0 ] [ = ] [ / ]");
    }
}