public abstract class Employee {
    protected String name;
    protected int age;
    protected long salaryPerHour;
    protected int experience;

    public abstract String getJobTitle();
    
    public void setSalary(long salary) {
        this.salaryPerHour = salary;
    }

    public String getName() {return name;}
    public double getSalary() {return salaryPerHour;}
    public int getAge() {return age;}
    public int getExperience() {return experience;}
}