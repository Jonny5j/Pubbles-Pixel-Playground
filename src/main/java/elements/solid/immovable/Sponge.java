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
            Pixel ne = this.getN(grid);
            Pixel e = this.getE(grid);
            Pixel se = this.getSE(grid);
            Pixel s = this.getS(grid);
            Pixel sw = this.getSW(grid);
            Pixel w = this.getW(grid);
            Pixel nw = this.getNW(grid);

            if (n != null && n.getClass().getSimpleName().equals("Water")) {
                grid[this.x][this.y - 1] = null;
            }
            if (ne != null && ne.getClass().getSimpleName().equals("Water")) {
                grid[this.x + 1][this.y - 1] = null;
            }
            if (e != null && e.getClass().getSimpleName().equals("Water")) {
                grid[this.x + 1][this.y] = null;
            }
            if (se != null && se.getClass().getSimpleName().equals("Water")) {
                grid[this.x + 1][this.y + 1] = null;
            }
            if (s != null && s.getClass().getSimpleName().equals("Water")) {
                grid[this.x][this.y + 1] = null;
            }
            if (sw != null && sw.getClass().getSimpleName().equals("Water")) {
                grid[this.x - 1][this.y + 1] = null;
            }
            if (w != null && w.getClass().getSimpleName().equals("Water")) {
                grid[this.x - 1][this.y] = null;
            }
            if (nw != null && nw.getClass().getSimpleName().equals("Water")) {
                grid[this.x - 1][this.y - 1] = null;
            }
        } catch (IndexOutOfBoundsException ignored) {}


        return grid;
    }

}
