public class Charisma extends Skill {
    @Override
    public void enhanceSkill(Sims sim, Wrapper<String> message) {
        String simType = sim.getType();
        String mood = sim.mood;
        if (simType.equals("Human") && mood.equals("Inspired")) {
            setLevel(getLevel() + 2);
            sim.mood = "Confident";
            message.set(sim.name + " shines brightly in social situations.");
        }
        else if (simType.equals("Human")) {
            setLevel(getLevel() + 1);
            sim.mood = "Inspired";
            message.set(sim.name + " trains their charisma skill and feels confident.");
        }
        else if (simType.equals("Vampire")) {
            setLevel(getLevel() + 1);
            sim.mood = "Confident";
            message.set(sim.name + " charms everyone effortlessly and feels confident.");
        }
        else if (simType.equals("Alien") && sim.friendIds.size() >= 2) {
            setLevel(getLevel() + 2);
            sim.mood = "Curious";
            message.set(sim.name + " learns something new about human behaviour.");
        } 
        else if (simType.equals("Alien")) {
            setLevel(getLevel() + 1);
            sim.mood = "Curious";
            message.set(sim.name + " observes human interaction and trains charisma.");
        }
    }
}
