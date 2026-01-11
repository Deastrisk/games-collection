

public class One implements State {
    @Override
    public void handle(Context context) {
        context.setState(new Two());
    }
}
