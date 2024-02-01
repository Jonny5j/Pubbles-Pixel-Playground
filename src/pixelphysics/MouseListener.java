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
    private static int selectedPixelIndex;
    private static final String[] pixelLabels = {"Brick", "Random", "Sand"}; // Add future pixels here to add to menu


    public MouseListener(PixelPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
//            System.out.println("LMB");
            switch (pixelLabels[selectedPixelIndex]) {
                case "Brick":
                    newBrick(e);
                    break;
                case "Random":
                    newRandom(e);
                    break;
                case "Sand":
                    newSand(e);
                    break;
            }
        } else if (SwingUtilities.isRightMouseButton(e)) {
//            System.out.println("RMB");
            this.panel.removePixel(e.getX(), e.getY());
        } else if (SwingUtilities.isMiddleMouseButton(e)) {
//            System.out.println("MMB");
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println(e.getScrollAmount());

        selectedPixelIndex++;
        if (selectedPixelIndex >= pixelLabels.length) {
            selectedPixelIndex -= pixelLabels.length;
        }
    }

    public String getSelectedPixel() {
        return pixelLabels[selectedPixelIndex];
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

}
