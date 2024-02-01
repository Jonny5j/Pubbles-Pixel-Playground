package pixelphysics;

import java.awt.*;
import java.util.List;
import java.util.LinkedList;
import javax.swing.*;

public class PixelPanel extends JPanel {

    static int NUM_PIXELS_HORIZONTAL = 256;
    static int NUM_PIXELS_VERTICAL = 128;
    public static Pixel[][] pixelGrid = new Pixel[NUM_PIXELS_HORIZONTAL][NUM_PIXELS_VERTICAL];
    public static List<Pixel> placedPixels = new LinkedList<>();

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
            pixelGrid = p.updatePos(pixelGrid);
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
