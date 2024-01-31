package pixelphysics;

import java.awt.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;

public class PixelPanel extends JPanel {

    static int NUM_PIXELS = 128;
    public Pixel[][] pixelGrid = new Pixel[NUM_PIXELS][NUM_PIXELS];
    public List<Pixel> placedPixels = new LinkedList<>();

    public PixelPanel() {
        super();
        this.setPreferredSize(new Dimension(NUM_PIXELS * Pixel.PIXEL_SIZE, NUM_PIXELS * Pixel.PIXEL_SIZE));
        this.setBackground(getBackground());
    }

    public void addPixel(Pixel p) {
        if (pixelGrid[p.x][p.y] != null) {
            System.out.println("Cell is occupied by " + pixelGrid[p.x][p.y].getClass());
            return;
        }

        System.out.println("Pixel Created at: " + p.x + ", " + p.y + ". Color: " + p.c);

        pixelGrid[p.x][p.y] = p;
        placedPixels.add(p);

        this.repaint();
    }

    public void step() {
        for (Pixel p : placedPixels) {

            boolean checkLeftFirst = new Random().nextBoolean();

            if (p.y >= NUM_PIXELS - 1) { // Pixel is at the bottom of the screen
                continue;
            } else if (pixelGrid[p.x][p.y + 1] == null) { // Empty space below
                pixelGrid[p.x][p.y] = null;
                p.fallDown();
            } else if (checkLeftFirst) { // Check left first
                if (pixelGrid[p.x - 1][p.y + 1] == null) { // Left empty
                    pixelGrid[p.x][p.y] = null;
                    p.fallLeft();
                } else if (pixelGrid[p.x + 1][p.y + 1] == null) { // Right empty
                    pixelGrid[p.x][p.y] = null;
                    p.fallRight();
                }
            } else { // Check Right First
                if (pixelGrid[p.x + 1][p.y + 1] == null) { // Right empty
                    pixelGrid[p.x][p.y] = null;
                    p.fallRight();
                } else if (pixelGrid[p.x - 1][p.y + 1] == null) { // Left empty
                    pixelGrid[p.x][p.y] = null;
                    p.fallLeft();
                }
            }

            pixelGrid[p.x][p.y] = p;
            this.repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Pixel[] cols : pixelGrid) {
            for (Pixel p : cols) {
                if (p == null) {
                    continue;
                }

                p.draw(g);

            }
        }
    }

}
