public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name, int age) {
        this.name = name;
        this.age = age;

        this.experience = 0;
        this.salaryPerHour = 1_000_000;
    }

    @Override
    public String getJobTitle() {
        return "PartTimeEmployee";
    }
}
