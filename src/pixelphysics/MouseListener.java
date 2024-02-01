package pixelphysics;

import liquids.*;
import solids.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MouseListener extends MouseAdapter {

    private final int PIXEL_DELAY = 20; // Delay between place/remove operations in ms
    private final PixelPanel panel;
    private static int selectedPixelIndex;
    private static Timer timer;
    private int mouseX;
    private int mouseY;
    private static final String[] pixelLabels = {"Brick", "Random", "Sand", "Water"}; // Add future pixels here to add to menu


    public MouseListener(PixelPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();

        if (SwingUtilities.isLeftMouseButton(e)) {
            timer = new Timer(PIXEL_DELAY, actionEvent -> lmbPressed());
        }

        if (SwingUtilities.isRightMouseButton(e)) {
            timer = new Timer(PIXEL_DELAY, actionEvent -> rmbPressed());
        }
        timer.start();
    }

    public void mouseReleased(MouseEvent e) {
        timer.stop();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
        timer.stop();
        if (SwingUtilities.isLeftMouseButton(e)) {
            lmbPressed();
        }

        if (SwingUtilities.isRightMouseButton(e)) {
            rmbPressed();
        }
        timer.start();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getUnitsToScroll() > 0) {
            selectedPixelIndex++;
            if (selectedPixelIndex >= pixelLabels.length) {
                selectedPixelIndex -= pixelLabels.length;
            }
        } else if (e.getUnitsToScroll() < 0) {
            selectedPixelIndex--;
            if (selectedPixelIndex <= 0) {
                selectedPixelIndex += pixelLabels.length - 1;
            }
        }
    }

    private void lmbPressed() {
        switch (pixelLabels[selectedPixelIndex]) {
            case "Brick":
                this.panel.addPixel(new Brick(this.mouseX, this.mouseY));
                break;
            case "Random":
                Random random = new Random();

                float r = (float) (random.nextFloat() / 2f + 0.5);
                float g = (float) (random.nextFloat() / 2f + 0.5);
                float b = (float) (random.nextFloat() / 2f + 0.5);

                this.panel.addPixel(new Pixel(new Color(r, g, b), this.mouseX, this.mouseY));
                break;
            case "Sand":
                this.panel.addPixel(new Sand(this.mouseX, this.mouseY));
                break;
            case "Water":
                this.panel.addPixel(new Water(this.mouseX, this.mouseY));
                break;
        }
    }

    private void rmbPressed() {
        panel.removePixel(this.mouseX, this.mouseY);
    }

    public String getSelectedPixel() {
        return pixelLabels[selectedPixelIndex];
    }

}
