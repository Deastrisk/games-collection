public class Human extends Sims {
    public Human(String name) {
        super(name, 0);
    }

    @Override
    public String getType() {
        return "Human";
    }
}
