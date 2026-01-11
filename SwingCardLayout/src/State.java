public interface State {
    public boolean hasBeenLoaded();
    public void handle(Context context);
    public void load(Context context);
}
