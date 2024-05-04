package elements.solid.moveable;

import pixelphysics.PixelPanel;
import elements.*;

import java.awt.*;

public class Sand extends FallingSolid {

    public Sand(int x, int y) {
        super(Color.YELLOW, x, y);
    }

    @Override
    public Pixel[][] step(Pixel[][] grid) {
        try {
            if (getS(grid) == null) {
                return this.moveS(grid);
            } else if (getS(grid).getClass().getSimpleName().equals("Water")) {
                return this.swapPixels(getS(grid), grid);
            } else {
                this.moveRandom(grid);
            }
        } catch (IndexOutOfBoundsException ignored) {}

        return grid;
    }

}
