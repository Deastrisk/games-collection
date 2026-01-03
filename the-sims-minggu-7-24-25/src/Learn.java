public class Learn implements Pages {
    Sims sim;
    public Learn(Sims sim) {
        this.sim = sim;
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
    public PageType handleInput(Integer inp) {
        switch (inp) {
            case 1: 
                sim.enhanceCooking();
                return PageType.MAP;
            case 2: 
                sim.enhanceLogic();
                return PageType.MAP;
            case 3: 
                sim.enhanceCharisma();
                return PageType.MAP;
        }
    }
}
