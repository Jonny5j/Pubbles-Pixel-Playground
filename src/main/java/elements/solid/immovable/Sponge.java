package elements.solid.immovable;

import elements.*;
import java.awt.*;

public class Sponge extends FloatingSolid {

    public Sponge(int x, int y) {
        super(Color.GREEN, x, y);
    }

    @Override
    public Pixel[][] step(Pixel[][] grid) {
        try {
            if (this.getN(grid).getClass().getSimpleName().equals("Water")) {
                grid[this.x][this.y - 1] = null;
            }
            if (this.getE(grid).getClass().getSimpleName().equals("Water")) {
                grid[this.x + 1][this.y] = null;
            }
            if (this.getS(grid).getClass().getSimpleName().equals("Water")) {
                grid[this.x][this.y + 1] = null;
            }
            if (this.getW(grid).getClass().getSimpleName().equals("Water")) {
                grid[this.x - 1][this.y] = null;
            }
        } catch (NullPointerException ignored) {}

        return grid;
    }

}
