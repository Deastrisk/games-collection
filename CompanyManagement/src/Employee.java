public abstract class Employee {
    private String name;
    private int age;
    private double salary;
    private double experience;

    public abstract String getJobTitle();

    public String getName() {return name;}
    public int getAge() {return age;}
    public double getSalary() {return salary;}
    public double getExperience() {return experience;}

    public void setSalary(double salary) {this.salary = salary;}
}