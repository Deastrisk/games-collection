package pages;

import data.PlayModel;

public class PlayState implements Page {
    @Override
    public void enter(PagesContext context) {
        context.showPage(Pages.PLAY);
    }

    @Override
    public void exit(PagesContext context) {}

    @Override
    public void update(PagesContext context) {
        KeyHandler keyH = context.getKeyHandler();
        PlayModel playModel = context.getPlayModel();

        if (keyH.upPressed) {
            playModel.playerHeadY -= playModel.playerSpeed;
        } else if (keyH.downPressed) {
            playModel.playerHeadY += playModel.playerSpeed;
        } else if (keyH.leftPressed) {
            playModel.playerHeadX -= playModel.playerSpeed;
        } else if (keyH.rightPressed) {
            playModel.playerHeadX += playModel.playerSpeed;
        }
    }
}
