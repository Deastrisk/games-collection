
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Four implements State {
    private State next;
    private boolean loaded;

    Four() {
        loaded = false;
    }

    public boolean hasBeenLoaded() {
        return loaded;
    }

    public void load(Context context) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        JButton btn = new JButton("4");
        btn.addActionListener(e -> {
            next = new One();
        });
        panel.add("4", btn);

        context.getContainer().add(panel);
        this.loaded = true;
    }

    @Override
    public void handle(Context context) {
        if (!loaded) {
            load(context);
        }
        context.setState(next);
    }
}
