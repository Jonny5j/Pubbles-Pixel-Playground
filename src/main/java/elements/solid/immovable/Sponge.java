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
            Pixel n = this.getN(grid);
            Pixel e = this.getE(grid);
            Pixel s = this.getS(grid);
            Pixel w = this.getW(grid);

            if (n != null && n.getClass().getSimpleName().equals("Water")) {
                grid[this.x][this.y - 1] = null;
            } else if (e != null && e.getClass().getSimpleName().equals("Water")) {
                grid[this.x + 1][this.y] = null;
            } else if (s != null && s.getClass().getSimpleName().equals("Water")) {
                grid[this.x][this.y + 1] = null;
            } else if (w != null && w.getClass().getSimpleName().equals("Water")) {
                grid[this.x - 1][this.y] = null;
            }
        } catch (IndexOutOfBoundsException ignored) {}


        return grid;
    }

}
