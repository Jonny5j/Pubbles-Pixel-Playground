package pixelphysics;

import elements.Pixel;

import javax.swing.*;
import java.awt.*;

public class PixelPanel extends JPanel {
    public static int PIXEL_SIZE = 4;
    public static int numPixelsHorizontal, numPixelsVertical;
    public static Pixel[][] pixelGrid;


    public PixelPanel(int w, int h) {
        super();
        numPixelsHorizontal = w / PIXEL_SIZE;
        numPixelsVertical = h / PIXEL_SIZE;
        pixelGrid = new Pixel[numPixelsHorizontal][numPixelsVertical];
        this.setPreferredSize(new Dimension(w, h));
    }

    public static void addPixel(Pixel p) {
        if (pixelGrid[p.x][p.y] != null) {
            System.out.println("Cell is occupied by " + pixelGrid[p.x][p.y].getClass());
            return;
        }

        System.out.println(p.getClass() + " Created at: " + p.x + ", " + p.y + ". Color: " + p.c);

        pixelGrid[p.x][p.y] = p;
    }

    public static Pixel removePixel(int mouseX, int mouseY) {
        Pixel removedPixel = pixelGrid[mouseX / PIXEL_SIZE][mouseY / PIXEL_SIZE];
        pixelGrid[mouseX / PIXEL_SIZE][mouseY / PIXEL_SIZE] = null;
        System.out.println("Removed pixel at " + mouseX / PIXEL_SIZE + ", " + mouseY / PIXEL_SIZE);
        return removedPixel;
    }

    public void stepAll() {
        for (int y = numPixelsVertical - 1; y > 0; y--) {
            for (int x = 0; x < numPixelsHorizontal; x++) {
                Pixel p = pixelGrid[x]
                        [y];
                if (p == null) {
                    continue;
                }
                pixelGrid = p.step(pixelGrid);
                this.repaint();
            }
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
