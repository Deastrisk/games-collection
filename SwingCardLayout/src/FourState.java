public class FourState implements State {
    @Override
    public void enter(Context context) {
        context.showCard(States.FOUR);
    }

    @Override
    public void exit(Context context) {

    }
}
