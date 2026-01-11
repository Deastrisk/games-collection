public class Two implements State {
    

    @Override
    public void handle(Context context) {
        context.setState(new Three());
    }
}
