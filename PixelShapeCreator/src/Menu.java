public interface Menu {
    MenuType IODisplay();
    MenuType handleInput(int input);
    int getInput();
}
