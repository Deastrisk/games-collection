public class Human extends Sims {
    public Human(String name, long id) {
        super(name, id, null);
    }

    @Override
    public String getType() {
        return "Human";
    }
}
