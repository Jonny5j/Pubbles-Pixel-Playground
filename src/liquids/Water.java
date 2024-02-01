package liquids;

import pixelphysics.Pixel;

import java.awt.*;
import java.util.Random;

public class Water extends Pixel {

    public Water(int x, int y) {
        super(Color.BLUE, x, y);
    }

    @Override
    public Pixel[][] updatePos(Pixel[][] pixelGrid) {
        int pickDirection = new Random().nextInt(2); // Direction search preference

        try {
            if (checkS(pixelGrid)) {
                return this.moveS(pixelGrid);
            }

            switch (pickDirection) {
                case 0: // E preferred
                    if (this.checkE(pixelGrid)) {
                        return this.moveE(pixelGrid);
                    } else if (this.checkW(pixelGrid)) {
                        return this.moveW(pixelGrid);
                    }
                case 1: // W preferred
                    if (this.checkW(pixelGrid)) {
                        return this.moveW(pixelGrid);
                    } else if (this.checkE(pixelGrid)) {
                        return this.moveE(pixelGrid);
                    }
                    break;
            }
        } catch (IndexOutOfBoundsException e) {
            return pixelGrid;
        }

        return pixelGrid;
    }



}
