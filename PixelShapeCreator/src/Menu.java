public interface Menu {
    void display();
    MenuType handleInput(int input);
    int getInput();
}
