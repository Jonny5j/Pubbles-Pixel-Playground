package solids;

import pixelphysics.Pixel;

import java.awt.*;
import java.util.Random;

public class Sand extends FallingSolid {

    public Sand(int x, int y) {
        super(Color.YELLOW, x, y);
    }

    @Override
    public Pixel[][] updatePos(Pixel[][] pixelGrid) {
        try {
            if (getS(pixelGrid) == null) {
                return this.moveS(pixelGrid);
            } else if (getS(pixelGrid).getClass().getPackageName().equals("liquids")) {
                return this.swapS(pixelGrid);
            }

            return this.moveRandom(pixelGrid);
        } catch (IndexOutOfBoundsException e) {
            return pixelGrid;
        }
    }

    private Pixel[][] swapS(Pixel[][] pixelGrid) {
        Pixel other = pixelGrid[this.x][this.y + 1];
        other.y--;
        this.y++;
        pixelGrid[other.x][other.y] = other;
        pixelGrid[this.x][this.y] = this;
        return pixelGrid;
    }


}
