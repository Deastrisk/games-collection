public class ThreeState implements State {
    @Override
    public void enter(Context context) {
        context.showCard(States.THREE);
    }

    @Override
    public void exit(Context context) {}
}
