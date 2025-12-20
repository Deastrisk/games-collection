import java.util.Scanner;
import java.util.ArrayList;aa

public class SimpleCalculator {
    public static void main(String[] args) throws Exception {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.calculator();
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

    double result = 0;
    String input = "";
    String a;
    String b;
    char ops;

    // private Pattern isEquationPattern = Pattern.compile("^-?\\d+(\\.\\d+)?([\\+-\\*/](\\(-\\d+(\\.\\d+)?\\))|(\\d+(\\.\\d+)?))+$");

    private void calculator() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            display();
            char input = getCalculatorInput(scanner);
            if (input != 0) {
                appendInput(input);
            }
            System.out.println(isValidEquation(this.input));
        }
    }

    static boolean isOperator(char c) {
        return (c == '*' || c == '+' || c == '/' || c == '-');
    }

    static boolean isValidCharacter(char c) {
        return (Character.isDigit(c) ||
                isOperator(c) ||
                c == '(' ||
                c == ')' ||
                c == '.'
            );
    }

    private boolean isValidEquation(String equationStr) {
        // equation is empty
        if (equationStr.isEmpty()) return false;

        // splits equationStr into an array of chars
        int equationLength = equationStr.length();
        char[] equation = new char[equationLength];
        equationStr.getChars(0, equationLength, equation, 0);

        // first char isn't valid
        if (!Character.isDigit(equation[0]) && equation[0] != '-' && equation[0] != '(') {
            return false;
        }

        // check for final character
        if (equation[equationLength - 1] == '(') return false;
        if (isOperator(equation[equationLength - 1])) return false;
        
        // makes a count of the parenthesis
        int parenthesisCount = 0;
        if (equation[0] == '(') parenthesisCount++;

        // all possible characters are [0-9]|ops
        for (int i = 1; i < equationLength; i++) {
            // there is an invalid character in the equation
            if (!isValidCharacter(equation[i])) {
                return false;
            }
                
            // all combs are: [0-9](        X
            //                [0-9])        V
            //                [0-9][0-9]    V
            //                [0-9]ops      V
            //                [0-9](final)  V
            if (Character.isDigit(equation[i - 1])) {
                if (equation[i] == '(') return false;
            } 

            // all combs are: ops(        V
            //                ops)        X
            //                ops[0-9]    V
            //                opsops      X
            //                ops(final)  X
            else if (isOperator(equation[i - 1])) {
                if (isOperator(equation[i])) return false;
                if (equation[i] == ')') return false;
            }

            // all combs are: ((        V
            //                ()        X
            //                ([0-9]    V
            //                (-        V
            //                (ops&&!-  X
            //                ((final)  X
            else if (equation[i - 1] == '(') {
                if (isOperator(equation[i]) && equation[i] != '-') return false;
                if (equation[i] == ')') return false;
            }

            // all combs are: )(        X
            //                ))        V
            //                )[0-9]    X
            //                )ops      V
            //                )(final)  V
            else if (equation[i - 1] == ')') {
                if (Character.isDigit(equation[i])) return false;
                if (equation[i] == '(') return false;
            }

            // count parenthesis
            if (equation[i] == '(') parenthesisCount++;
            if (equation[i] == ')') parenthesisCount--;

            // more ) than (
            if (parenthesisCount < 0) return false;
        }

        // makes sure every open parenthesis has a closing one
        if (parenthesisCount != 0) return false;

        return true;
    }

    private char getCalculatorInput(Scanner scanner) {
        char c = scanner.nextLine().charAt(0);
        if (!isValidCharacter(c)) {
            return 0;
        }

        return c;
    }

    private void appendInput(char input) {
        this.input = this.input + input;
    }

    private void getAllDoubles(String equation, ArrayList<Double> output) {
        double buffer = 0;
        String bufferStr = "";
        for (int i = 0, wordLen = 0; i < equation.length(); i++, wordLen++) {
            if (wordLen == 0 && )
            bufferStr = bufferStr + equation[i];
        }
    }

    private int calculate() {
        // turn string number into double
        try {
            double num = Double.parseDouble(b);
        } catch (NumberFormatException e) {
            System.out.println("Invaid Number format");
            return 1;
        }

        switch (ops) {
            case '+':
                result += num;
                break;
            case '-':
                result -= num;
                break;
            case '/':
                result /= num;
                break;
            case '*':
                result *= num;
                break;
            default:
                System.out.println("Invalid oparator");
                return 2;
        }
        return 0;
    }
}