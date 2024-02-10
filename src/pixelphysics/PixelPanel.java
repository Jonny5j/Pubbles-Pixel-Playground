package pixelphysics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PixelPanel extends JPanel {
    public static int PIXEL_SIZE = 4;
    public static Pixel[][] pixelGrid;
    public final static List<Pixel> placedPixels = new ArrayList<>();


    public PixelPanel(int w, int h) {
        super();
        int numPixelsHorizontal = w / PIXEL_SIZE;
        int numPixelsVertical = h / PIXEL_SIZE;
        pixelGrid = new Pixel[numPixelsHorizontal][numPixelsVertical];
        this.setPreferredSize(new Dimension(numPixelsHorizontal, numPixelsVertical));
    }

    public void addPixel(Pixel p) {
        if (pixelGrid[p.x][p.y] != null) {
            System.out.println("Cell is occupied by " + pixelGrid[p.x][p.y].getClass());
            return;
        }

        System.out.println(p.getClass() + " Created at: " + p.x + ", " + p.y + ". Color: " + p.c);

        pixelGrid[p.x][p.y] = p;
        placedPixels.addFirst(p);

        this.repaint();
    }

    public Pixel removePixel(int x, int y) {
        if (pixelGrid[x / PIXEL_SIZE][y / PIXEL_SIZE] == null) {
            return null;
        }

        Pixel removed = pixelGrid[x / PIXEL_SIZE][y / PIXEL_SIZE];
        System.out.println("Removed pixel at " + x + ", " + y);
        pixelGrid[x / PIXEL_SIZE][y / PIXEL_SIZE] = null;

        this.repaint();
        return removed;

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
