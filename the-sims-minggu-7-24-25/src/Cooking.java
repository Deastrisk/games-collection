public class Cooking extends Skill {

    @Override
    public void enhanceSkill(Sims sim, Wrapper<String> message) {
        String simType = sim.getType();
        String mood = sim.mood;
        if (simType.equals("Human") && mood.equals("Inspired")) {
            setLevel(getLevel() + 2);
            sim.mood = "Inspired";
            message.set(sim.name + " feels creative in the kitchen.");
        }
        else if (simType.equals("Human")) {
            setLevel(getLevel() + 1);
            sim.mood = "Inspired";
            message.set(sim.name + " learns to cook and feels inspired.");
        }
        else if (simType.equals("Vampire") && mood.equals("Uncomfortable")) {
            setLevel(getLevel() + 0);
            sim.mood = "Uncomfortable";
            message.set(sim.name + " reluctantly practices cooking and feels uncomfortable");
        }
        else if (simType.equals("Vampire")) {
            setLevel(getLevel() + 1);
            sim.mood = "Uncomfortable";
            message.set(sim.name + " reluctantly practices cooking and feels uncomfortable");
        }
        else if (simType.equals("Alien")) {
            int lvlUp = (int) (Math.random() * 2) * 2;
            setLevel(getLevel() + lvlUp);

            if (lvlUp == 0) {
                sim.mood = "Confused";
                message.set(sim.name + " tries a new recipe and feels confused.");
            } else {
                sim.mood = "Inspired";
                message.set(sim.name + " blends strange ingredients and feels inspired.");
            }
        }
    }
}
