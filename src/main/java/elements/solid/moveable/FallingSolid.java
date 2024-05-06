package elements.solid.moveable;

import elements.Pixel;

import java.awt.*;
import java.util.Random;

public class FallingSolid extends Pixel {

    public FallingSolid(Color c, int x, int y) {
        super(c, x, y);
    }

    public Pixel[][] step(Pixel[][] grid) {
        try {
            if (getS(grid) == null) {
                return this.moveS(grid);
            } else {
                return this.moveRandom(grid);
            }
        } catch (IndexOutOfBoundsException ignored) {}

        return grid;
    }

    protected Pixel[][] moveRandom(Pixel[][] grid) {
        if (new Random().nextBoolean()) { // Fall direction search preference
            if (this.getE(grid) == null && this.getSE(grid) == null) {
                return this.moveSE(grid);
            } else if (this.getW(grid) == null && this.getSW(grid) == null) {
                return this.moveSW(grid);
            }
        } else {
            if (this.getW(grid) == null && this.getSW(grid) == null) {
                return this.moveSW(grid);
            } else if (this.getE(grid) == null && this.getSE(grid) == null) {
                return this.moveSE(grid);
            }
        }

        return grid;
    }

}
