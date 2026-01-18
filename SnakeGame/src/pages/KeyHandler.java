package pages;

import data.SettingsData;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean leftPressed = false;
    public boolean rightPressed = false;

    final SettingsData settings;

    public KeyHandler(SettingsData settings) {
        this.settings = settings;
    }

    @Override
    public void keyReleased(KeyEvent e) {
         
        int code = e.getKeyCode();
        if (code == settings.moveDown) {
            downPressed = false;
        } else if (code == settings.moveLeft) {
            leftPressed = false;
        } else if (code == settings.moveRight) {
            rightPressed = false;
        } else if (code == settings.moveUp) {
            upPressed = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == settings.moveDown) {
            downPressed = true;
            // System.out.println(e.getKeyChar());
        } else if (code == settings.moveLeft) {
            leftPressed = true;
        } else if (code == settings.moveRight) {
            rightPressed = true;
        } else if (code == settings.moveUp) {
            upPressed = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}