package pixelphysics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PixelPanel extends JPanel {

    static int NUM_PIXELS_HORIZONTAL = 256;
    static int NUM_PIXELS_VERTICAL = 128;
    public static Pixel[][] pixelGrid = new Pixel[NUM_PIXELS_HORIZONTAL][NUM_PIXELS_VERTICAL];
    public final static List<Pixel> placedPixels = new ArrayList<>();


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
        placedPixels.addFirst(p);

        this.repaint();
    }

    public void step() {
        List<Pixel> readAll = new ArrayList<>(placedPixels); // Create a copy to read from to avoid ConcurrentModificationException
        for (Pixel p : readAll) {
            pixelGrid = p.updatePos(pixelGrid);
            this.repaint();
        }
    }

    @Override
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
