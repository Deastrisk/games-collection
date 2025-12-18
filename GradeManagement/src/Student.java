
import java.util.ArrayList;

public class Student {
    static int count = 0;

    // key value pairs of subject
    int absent;
    String name;
    ArrayList<Grade> grades;

    public Student(String name, int absent) {
        this.name = name;
        this.absent = absent;
        Student.count++;
    }

    public void getGrade() {
        System.out.printf("Name: %s ; Absent: %d\n", this.name, this.absent);
        for (Grade grade : grades) {
            System.out.printf("%s : %d", grade.subject, grade.grade);
        }
    }

    public void setGrade(String subject, int score) {
        this.grades.subject = subject;
        this.grades.grade = score;
    }
}
