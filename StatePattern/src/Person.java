public class Person {
    private String name;
    private String major;
    private int semester;
    private float ipk;

    public Person(String name, String major, int semester, float ipk) {
        this.name = name;
        this.major = major;
        this.semester = semester;
        this.ipk = ipk;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getSemester() { return semester; }
    public float getIpk() { return ipk; }

    public void setName(String name) { this.name = name; }
    public void setMajor(String major) { this.major = major; }
    public void setSemester(int semester) { this.semester = semester; }
    public void setIpk(float ipk) { this.ipk = ipk; }
}
