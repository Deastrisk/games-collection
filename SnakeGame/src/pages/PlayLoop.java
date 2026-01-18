package pages;

import data.PlayModel;

public class PlayLoop implements Runnable {
    private PlayState state;
    private final PlayModel model;
    private final PlayPanel panel;
    private final PagesContext context;

    Thread gameThread;

    public PlayLoop(PagesContext context) {
        this.context = context;
        this.model = context.getPlayModel();
        this.panel = context.getPlayPanel();
    }

    public void setState(PlayState state) {
        this.state = state;
    }
    
    @Override
    public void run() {
        long currentTime = System.nanoTime();

        while (gameThread != null) {
            // update game data
            state.update(context);

            // draw the screen
            panel.repaint();
        }
    }
}
