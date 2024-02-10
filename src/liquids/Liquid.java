package liquids;

import pixelphysics.Pixel;

import java.awt.*;
import java.util.Random;

public class Liquid extends Pixel {

    public Liquid(Color c, int x, int y) {
        super(c, x, y);
    }

    @Override
    public Pixel[][] updatePos(Pixel[][] pixelGrid) {
        int pickDirection = new Random().nextInt(2); // Direction search preference

        try {
            if (this.y < pixelGrid[0].length - 1 && getS(pixelGrid) == null) {
                return this.moveS(pixelGrid);
            } else {
                switch (pickDirection) {
                    case 0: // E preferred
                        if (this.getE(pixelGrid) == null) {
                            return this.moveE(pixelGrid);
                        } else if (this.getW(pixelGrid) == null) {
                            return this.moveW(pixelGrid);
                        }
                    case 1: // W preferred
                        if (this.getW(pixelGrid) == null) {
                            return this.moveW(pixelGrid);
                        } else if (this.getE(pixelGrid) == null) {
                            return this.moveE(pixelGrid);
                        }
                        break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return pixelGrid;
        }

        return pixelGrid;
    }



}
