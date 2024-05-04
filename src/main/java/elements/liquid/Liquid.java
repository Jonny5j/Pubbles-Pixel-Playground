package elements.liquid;

import elements.Pixel;
import pixelphysics.PixelPanel;

import java.awt.*;
import java.util.Random;

public class Liquid extends Pixel {

    public Liquid(Color c, int x, int y) {
        super(c, x, y);
    }

    @Override
    public Pixel[][] step(Pixel[][] grid) {
        try {
            if(this.y < PixelPanel.numPixelsVertical - 1 && getS(grid) == null) {
                this.moveS(grid);
            } else {
                this.moveRandom(grid);
            }
        } catch (IndexOutOfBoundsException ignored) {}

        return grid;
    }

    public Pixel[][] moveRandom(Pixel[][] grid) {
        if (new Random().nextBoolean()) { // E preferred
            if (this.getE(grid) == null) {
                this.moveE(grid);
            } else if (this.getW(grid) == null) {
                this.moveW(grid);
            }
        } else { // W preferred
            if (this.getW(grid) == null) {
                this.moveW(grid);
            } else if (this.getE(grid) == null) {
                this.moveE(grid);
            }
        }

        return grid;
    }

}
