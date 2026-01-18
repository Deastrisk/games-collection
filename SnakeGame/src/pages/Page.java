package pages;

public interface Page {
    public void enter(PagesContext context);
    public void exit(PagesContext context);
    default void update(PagesContext context) {};
}
