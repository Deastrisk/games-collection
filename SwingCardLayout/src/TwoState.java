public class TwoState implements State {
    @Override
    public void enter(Context context) {
        context.showCard(States.TWO);
    }

    @Override
    public void exit(Context context) {}
}
