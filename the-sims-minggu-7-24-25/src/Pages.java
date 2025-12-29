interface Pages<T> {
    public PageType IODisplay();

    public T getInput();
    public PageType handleInput(T inp);
}
