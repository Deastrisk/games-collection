package data;

import java.awt.event.KeyEvent;

public class SettingsData {
    private int level = 1;

    public int moveUp = KeyEvent.VK_W;
    public int moveDown = KeyEvent.VK_S;
    public int moveLeft = KeyEvent.VK_A;
    public int moveRight = KeyEvent.VK_D;

    public SettingsData() {
    }
}
