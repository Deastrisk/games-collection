public class Vampire extends Sims {
    public Vampire(String name, long id) {
        super(name, id, 50);
    }

    @Override
    public String getType() {
        return "Vampire";
    }
}
