package pixelphysics;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MouseListener extends MouseAdapter {

    private final PixelPanel panel;

    public MouseListener(PixelPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Random random = new Random();

        float r = (float) (random.nextFloat() / 2f + 0.5);
        float g = (float) (random.nextFloat() / 2f + 0.5);
        float b = (float) (random.nextFloat() / 2f + 0.5);

        this.panel.addPixel(new Pixel(new Color(r, g, b), e.getX(), e.getY()));
    }

}
