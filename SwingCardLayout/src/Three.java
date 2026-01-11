public class Three implements State {
    @Override
    public void handle(Context context) {
        context.setState(new Four());
    }
}
