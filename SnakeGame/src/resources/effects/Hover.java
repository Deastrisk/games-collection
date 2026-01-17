package resources.effects;

import java.awt.*;
import java.awt.event.*;

public class Hover implements MouseListener {
    public final Color normal;
    public final Color hovered;
    public final Component c;

    public Hover(Component c, Color normal, Color hovered) {
        this.normal = normal;
        this.hovered = hovered;
        this.c = c;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        c.setForeground(normal);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        c.setForeground(hovered);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}
}
