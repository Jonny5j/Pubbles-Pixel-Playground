package pixelphysics;

import elements.solid.immovable.*;
import elements.solid.moveable.*;
import elements.liquid.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MouseListener extends MouseAdapter {

    private static int selectedPixelIndex;
    private final Timer timer = new Timer();
    private TimerTask leftTask;
    private TimerTask rightTask;
    private int mouseX;
    private int mouseY;
    private int brushSize = 1;
    private static final int DELAY = 1; // in ms
    private static final String[] pixelLabels = {"Brick", "Random", "Sand", "Water", "Sponge"}; // Add future pixels here to add to menu


    public MouseListener() {}

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if (e.getButton() == MouseEvent.BUTTON1) {
            timer.scheduleAtFixedRate(this.leftTask = new LeftTimerTask(), 0, DELAY);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            timer.scheduleAtFixedRate(this.rightTask = new RightTimerTask(), 0, DELAY);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            this.leftTask.cancel();
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            this.rightTask.cancel();
        }
    }

    public void mouseDragged(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getUnitsToScroll() > 0) { // Scroll wheel down
            if (e.isControlDown() && this.brushSize > 1) {
                this.brushSize--;
                System.out.println("Brush size: " + this.brushSize);
                return;
            }

            selectedPixelIndex++;
            if (selectedPixelIndex > pixelLabels.length - 1) {
                selectedPixelIndex = 0;
            }
        } else if (e.getUnitsToScroll() < 0) { // Scroll wheel up
            if (e.isControlDown() && this.brushSize < 8) {
                this.brushSize++;
                System.out.println("Brush size: " + this.brushSize);
                return;
            }

            selectedPixelIndex--;
            if (selectedPixelIndex < 0) {
                selectedPixelIndex = pixelLabels.length - 1;
            }
        }
    }

    private void lmbPressed() {
        switch (pixelLabels[selectedPixelIndex]) {
            case "Brick":
                for (int i = 0; i < brushSize; i++) {
                    for (int j = 0; j < brushSize; j++) {
                        try {
                            PixelPanel.addPixel(new Brick(this.mouseX - (i * PixelPanel.PIXEL_SIZE), this.mouseY - (j * PixelPanel.PIXEL_SIZE)));
                        } catch (IndexOutOfBoundsException ignored) {}
                    }
                }
                break;
            case "Random":
                for (int i = 0; i < brushSize; i++) {
                    for (int j = 0; j < brushSize; j++) {
                        try {
                            Random random = new Random();

                            float r = (float) (random.nextFloat() / 2f + 0.5);
                            float g = (float) (random.nextFloat() / 2f + 0.5);
                            float b = (float) (random.nextFloat() / 2f + 0.5);

                            PixelPanel.addPixel(new FallingSolid(new Color(r, g, b), this.mouseX - (i * PixelPanel.PIXEL_SIZE), this.mouseY - (j * PixelPanel.PIXEL_SIZE)));
                        } catch (IndexOutOfBoundsException ignored) {}
                    }
                }
                break;
            case "Sand":
                for (int i = 0; i < brushSize; i++) {
                    for (int j = 0; j < brushSize; j++) {
                        try {
                            PixelPanel.addPixel(new Sand(this.mouseX - (i * PixelPanel.PIXEL_SIZE), this.mouseY - (j * PixelPanel.PIXEL_SIZE)));
                        } catch (IndexOutOfBoundsException ignored) {}
                    }
                }
                break;
            case "Water":
                for (int i = 0; i < brushSize; i++) {
                    for (int j = 0; j < brushSize; j++) {
                        try {
                            PixelPanel.addPixel(new Water(this.mouseX - (i * PixelPanel.PIXEL_SIZE), this.mouseY - (j * PixelPanel.PIXEL_SIZE)));
                        } catch (IndexOutOfBoundsException ignored) {}
                    }
                }
                break;
            case "Sponge":
                for (int i = 0; i < brushSize; i++) {
                    for (int j = 0; j < brushSize; j++) {
                        try {
                            PixelPanel.addPixel(new Sponge(this.mouseX - (i * PixelPanel.PIXEL_SIZE), this.mouseY - (j * PixelPanel.PIXEL_SIZE)));
                        } catch (IndexOutOfBoundsException ignored) {}
                    }
                }
                break;
        }
    }

    private void rmbPressed() {
        for (int i = 0; i < brushSize; i++) {
            for (int j = 0; j < brushSize; j++) {
                try {
                    PixelPanel.removePixel(this.mouseX - (i * PixelPanel.PIXEL_SIZE), this.mouseY - (j * PixelPanel.PIXEL_SIZE));
                } catch (IndexOutOfBoundsException ignored) {}
            }
        }

    }

    public String getSelectedPixel() {
        return pixelLabels[selectedPixelIndex];
    }

    private class LeftTimerTask extends TimerTask {
        public void run() {
            if (System.currentTimeMillis() - scheduledExecutionTime() >= DELAY) {
                return;
            }
            lmbPressed();
        }
    }

    private class RightTimerTask extends TimerTask {
        public void run() {
            if (System.currentTimeMillis() - scheduledExecutionTime() >= DELAY) {
                return;
            }
            rmbPressed();
        }
    }

}
