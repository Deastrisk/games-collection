public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;

        this.salaryPerHour = Math.min(experience * 3_000_000 / 2 + 5_000_000, 20_000_000);
    }

    @Override
    public String getJobTitle() {
        return "FullTimeEmployee";
    }
}
