

public class SimpleCalculator {
    double result;
    public static final double PI = 3.14159265;

    public SimpleCalculator() {
        this.result = 5.123;
    }

    public static void main(String[] args) throws Exception {
        SimpleCalculator calculator = new SimpleCalculator();
        System.out.printf("Output: %f\n", calculator.result);
        System.out.println("PI: " + SimpleCalculator.PI);

        // otw
    }
}