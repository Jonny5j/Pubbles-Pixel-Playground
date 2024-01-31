package pixelphysics;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {

    private final PixelPanel panel;

    public MouseListener(PixelPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.panel.addPixel(new Pixel(Color.CYAN, e.getX(), e.getY()));
    }

}
