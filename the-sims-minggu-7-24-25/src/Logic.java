public class Logic extends Skill {
    @Override
    public void enhanceSkill(Sims sim, Wrapper<String> message) {
        String simType = sim.getType();
        String mood = sim.mood;
        if (simType.equals("Human") && mood.equals("Focused")) {
            setLevel(getLevel() + 2);
            sim.mood = "Focused";
            message.set(sim.name + "'s mind sharpens with every challenge.");
        }
        else if (simType.equals("Human")) {
            setLevel(getLevel() + 1);
            sim.mood = "Focused";
            message.set(sim.name + " learns to solve problems and feels focused.");
        }
        else if (simType.equals("Vampire") && sim.hunger < 30) {
            setLevel(getLevel() + 2);
            sim.mood = "Focused";
            message.set(sim.name + "' thirst fuels their intellect");
        }
        else if (simType.equals("Vampire")) {
            setLevel(getLevel() + 1);
            sim.mood = "Focused";
            message.set(sim.name + " studies ancient knowledge and feels focused.");
        }
        else if (simType.equals("Alien") && mood.equals("Focused")) {
            setLevel(getLevel() + 3);
            sim.mood = "Focused";
            message.set("'s interstellar brain lights up.");
        }
        if (simType.equals("Alien")) {
            setLevel(getLevel() + 2);
            sim.mood = "Focused";
            message.set(" deciphers complex patterns and feels focused.");
        }
    }
}
