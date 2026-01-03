public class Learn implements Pages {
    Sims sim;
    Wrapper<String> message;
    public Learn(Sims sim, Wrapper<String> message) {
        this.sim = sim;
        this.message = message;
    }

    @Override
    public PageType IODisplay() {
        System.out.println("""
                            Choose a skill to enhance:
                            1. Cooking Skill
                            2. Logic Skill
                            3. Charisma Skill
                            """);

        int inp = getInput();
        return handleInput(inp);
    }

    @Override
    public Integer getInput() {
        while (true) { 
            System.out.print(">> ");
            String inpStr = App.scanner.nextLine();
            try {
                int inp = Integer.parseInt(inpStr);
                if (inp < 1 || inp > 3) {
                    System.out.println("Input must be between 1-3");
                    continue;
                }
                return inp;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number");
            }
        }
    }

    @Override
    public PageType handleInput(Object inp) {
        switch ((int)inp) {
            case 1: 
                sim.skills.get("Cooking").enhanceSkill(sim, message);
                return PageType.MAP;
            case 2: 
                sim.skills.get("Logic").enhanceSkill(sim, message);
                return PageType.MAP;
            case 3: 
                sim.skills.get("Charisma").enhanceSkill(sim, message);
                return PageType.MAP;
        }

        return PageType.MAP;
    }
}
