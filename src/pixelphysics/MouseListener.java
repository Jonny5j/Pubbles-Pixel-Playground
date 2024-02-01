package pixelphysics;

import solids.Brick;
import solids.Sand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;

public class MouseListener extends MouseAdapter {

    private final PixelPanel panel;
    public MouseListener(PixelPanel panel) {
        this.panel = panel;
    }

    private int selectedPixelIndex;

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            System.out.println("LMB");
            switch (this.selectedPixelIndex) {
                case 0:
                    newRandom(e);
                    break;
                case 1:
                    newSand(e);
                    break;
//                case2:
//                    newWater(e);
            }
        } else if (SwingUtilities.isRightMouseButton(e)) {
            System.out.println("RMB");
            newBrick(e);
        } else if (SwingUtilities.isMiddleMouseButton(e)) {
            System.out.println("MMB");
            fillRectangle(e, new Sand(e.getX(), e.getY()));
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println("scroll");
        selectedPixelIndex += e.getScrollAmount();

        int NUM_TYPES = 2;
        while (selectedPixelIndex >= NUM_TYPES) {
            selectedPixelIndex -= NUM_TYPES;
        }
    }

    public void newBrick(MouseEvent e) {
        this.panel.addPixel(new Brick(e.getX(), e.getY()));
    }

    public void newRandom(MouseEvent e) {
        // Random Color Pixel
        Random random = new Random();

        float r = (float) (random.nextFloat() / 2f + 0.5);
        float g = (float) (random.nextFloat() / 2f + 0.5);
        float b = (float) (random.nextFloat() / 2f + 0.5);

        this.panel.addPixel(new Pixel(new Color(r, g, b), e.getX(), e.getY()));
    }

    public void newSand(MouseEvent e) {
        this.panel.addPixel(new Sand(e.getX(), e.getY()));
    }

    private void fillRectangle(MouseEvent e, Pixel p) {
//        for (int i = 0; i < e.getX(); i++) {
//            for (int j = 0; j < e.getY(); j++) {
//                this.panel.addPixel(p);
//            }
//        }
    }

}
