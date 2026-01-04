public class Alien extends Sims {
    public Alien(String name, long id) {
        super(name, id, null);
    }

    @Override
    public String getType() {
        return "Alien";
    }
}
