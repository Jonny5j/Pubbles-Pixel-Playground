package elements.liquid;

import elements.Pixel;

import java.awt.*;
import java.util.Random;

public class Liquid extends Pixel {

    public Liquid(Color c, int x, int y) {
        super(c, x, y);
    }

    @Override
    public Pixel[][] step(Pixel[][] grid) {
        try {
            if (getS(grid) == null) {
                return this.moveS(grid);
            } else {
                return this.moveRandom(grid);
            }
        } catch (IndexOutOfBoundsException ignored) {
            return this.moveRandom(grid);
        }
    }

    public Pixel[][] moveRandom(Pixel[][] grid) {
        if (new Random().nextBoolean() && this.getE(grid) == null) { // Fall direction search preference
            return this.moveE(grid);
        } else if (new Random().nextBoolean() && this.getW(grid) == null){
            return this.moveW(grid);
        }

        return grid;
    }

}
