public abstract class Skill {
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int newLevel) {
        level = newLevel;
    }

    public abstract void enhanceSkill(Sims sim, Wrapper<String> message);
}
