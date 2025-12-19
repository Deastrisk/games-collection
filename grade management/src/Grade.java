import java.util.HashMap;
import java.util.Scanner;

public class Grade {
    public enum Page {
        ADD_GRADE(1), 
        GRADE_INFORMATION(2), 
        EXIT(0), 
        MENU(3), 
        INVALID(4);

        private final int value;

        private Page(int value) {
            this.value = value;
        }
    }

    static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {

        Page page = Page.MENU;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Grade Manager ===");
            System.out.println("1. Add Student Grade");
            System.out.println("2. Grade information");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            switch (scanner.nextInt()) {
                case 0:
                    page = Page.EXIT;
                    break;
                case 1:
                    page = Page.ADD_GRADE;
                    break;
                case 2:
                    page = Page.GRADE_INFORMATION;
                    break;
                default:
                    page = Page.INVALID;
            }

            switch (page) {
                case EXIT:
                    return;
                case ADD_GRADE:
                    addGrade(scanner);
                    break;
                case GRADE_INFORMATION:
                    gradeInformation();
                    break;
                default:
                    invalidOption();
            }
        }
    }

    static private void invalidOption() {
        System.out.println("Invalid option");
    }

    static private int addGrade(Scanner scanner) {
        System.out.println("\n=== ADD GRADE ===");
        System.out.print("Input name : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        if (name.compareTo("") == 0) {
            System.out.println("Name must be filled");
            return 2;
        }

        System.out.print("Input grade: ");
        String gradeStr = scanner.nextLine();
        double grade;

        // validates grade input
        try {
            grade = Double.parseDouble(gradeStr);
        } catch (NumberFormatException e) {
            System.out.println("Must be a number!");
            return 3;
        }

        if (grade < 0 || grade > 100) {
            System.out.println("Grade cannot be under 0 or exceed 100");
            return 1;
        }
        grades.put(name, grade);

        System.out.println("Grade inputted successfully");
        return 0;
    }

    static private void gradeInformation() {
        System.out.println("\n=== GRADE INFORMATION ===");
        if (grades.isEmpty()) {
            System.out.println("Database currently empty...");
            return;
        }

        for (String name : grades.keySet()) {
            System.out.println(name + " : " + grades.get(name));
        }
    }
}
