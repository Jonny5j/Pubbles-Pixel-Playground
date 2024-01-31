package pixelphysics;

import java.awt.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.*;

public class PixelPanel extends JPanel {

    static int NUM_PIXELS_HORIZONTAL = 256;
    static int NUM_PIXELS_VERTICAL = 128;
    public Pixel[][] pixelGrid = new Pixel[NUM_PIXELS_HORIZONTAL][NUM_PIXELS_VERTICAL];
    public List<Pixel> placedPixels = new LinkedList<>();

    public PixelPanel() {
        super();
        this.setPreferredSize(new Dimension(NUM_PIXELS_HORIZONTAL * Pixel.PIXEL_SIZE, NUM_PIXELS_VERTICAL * Pixel.PIXEL_SIZE));
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

            if (p.y >= NUM_PIXELS_VERTICAL - 1) { // Pixel is at the bottom of the screen
                continue;
            }

            pixelGrid[p.x][p.y] = null;

            if (pixelGrid[p.x][p.y + 1] == null) { // Empty space below
                p.fallDown();
            } else if (checkLeftFirst) { // Check left first
                if (checkLeft(p)) {
                    p.fallLeft();
                } else if (checkRight(p)) {
                    p.fallRight();
                }
            } else { // Check Right First
                if (checkRight(p)) {
                    p.fallRight();
                } else if (checkLeft(p)) {
                    p.fallLeft();
                }
            }

            pixelGrid[p.x][p.y] = p;
            this.repaint();
        }
    }

    private boolean checkLeft(Pixel p) {
        return pixelGrid[p.x - 1][p.y] == null && pixelGrid[p.x - 1][p.y + 1] == null;
    }

    private boolean checkRight(Pixel p) {
        return pixelGrid[p.x + 1][p.y] == null && pixelGrid[p.x + 1][p.y + 1] == null;
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
