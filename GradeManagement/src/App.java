import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        Student marcio = new Student("Marcio", 1);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input your name: ");
            marcio.name = scanner.nextLine();

            System.out.println("Input your absent number: ");
            marcio.absent = scanner.nextInt();

            System.out.println("Input the subject: ");
            Subject subject = new Subject(Scanner.nextLine());

            System.out.println("Input your grade: ");
            marcio.;
        }

        System.out.printf("Your name is : %s", marcio.name);
        System.out.printf("Your name is : %s", marcio.name);
        System.out.printf("Your name is : %s", marcio.name);
    }
}
