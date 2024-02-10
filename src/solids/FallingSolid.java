package solids;

import pixelphysics.Pixel;

import java.awt.*;
import java.util.Random;

public class FallingSolid extends Pixel {

    public FallingSolid(Color c, int x, int y) {
        super(c, x, y);
    }

    public Pixel[][] updatePos(Pixel[][] pixelGrid) {
        try {
            if (getS(pixelGrid) == null) {
                return this.moveS(pixelGrid);
            }

            return this.moveRandom(pixelGrid);
        } catch (IndexOutOfBoundsException e) {
            return pixelGrid;
        }
    }

    public Pixel[][] moveRandom(Pixel[][] pixelGrid) {
        switch (new Random().nextInt(2)) { // Fall direction search preference
            case 0: // SE preferred
                if (this.getE(pixelGrid) == null && this.getSE(pixelGrid) == null) {
                    return this.moveSE(pixelGrid);
                } else if (this.getW(pixelGrid) == null && this.getSW(pixelGrid) == null) {
                    return this.moveSW(pixelGrid);
                }
            case 1: // SW preferred
                if (this.getW(pixelGrid) == null && this.getSW(pixelGrid) == null) {
                    return this.moveSW(pixelGrid);
                } else if (this.getE(pixelGrid) == null && this.getSE(pixelGrid) == null) {
                    return this.moveSE(pixelGrid);
                }
                break;
        }
        return pixelGrid;
    }

}
