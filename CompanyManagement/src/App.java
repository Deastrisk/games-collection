
public class App {
    public static void main(String[] args) throws Exception {
        // JFrame window = new JFrame();

        // window.setVisible(true);
        // window.setPreferredSize(new Dimension(600, 450));
        // window.setLayout(null);
        
        FullTimeEmployee fulltime = new FullTimeEmployee("Marcio", 50, 4);
        PartTimeEmployee parttime = new PartTimeEmployee("Amadeus", 18);

        System.out.println(parttime.getSalary());
        System.out.println(fulltime.getSalary());
    }
}
