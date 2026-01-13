public class OneState implements State {
    @Override
    public void enter(Context context) {
        context.showCard(States.ONE);
    }

    @Override
    public void exit(Context context) {}
}
