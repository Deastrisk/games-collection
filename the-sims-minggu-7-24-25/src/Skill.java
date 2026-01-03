public class Skill {
    public String name;
    public int level;

    public void effects(Sims sim, String skill, String mood) {
        String simType = sim.getType();
        if (simType.equals("Human")) {
            if (skill.equals("Cooking")) {
                
            }
            else if (skill.equals("Logic")) {
                
            }
            else if (skill.equals("Charisma")) {
    
            }
        }
        else if (simType.equals("Vampire")) {
            if (skill.equals("Cooking")) {

            }
            else if (skill.equals("Logic")) {
                
            }
            else if (skill.equals("Charisma")) {

            }
        }
        else if (simType.equals("Alien")) {
            if (skill.equals("Cooking")) {
    
            }
            else if (skill.equals("Logic")) {
                
            }
            else if (skill.equals("Charisma")) {
    
            }
        }
    }

    public void enhanceCooking() {
        
    }
}
