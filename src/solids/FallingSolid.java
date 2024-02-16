package solids;

import pixelphysics.Pixel;

import java.awt.*;
import java.util.Random;

public class FallingSolid extends Pixel {

    public FallingSolid(Color c, int x, int y) {
        super(c, x, y);
    }

    public void updatePos() {
        try {
            if (getS() == null) {
                this.moveS();
            } else {
                this.moveRandom();
            }
        } catch (IndexOutOfBoundsException ignored) {}
    }

    public void moveRandom() {
        if (new Random().nextBoolean()) { // Fall direction search preference
            if (this.getE() == null && this.getSE() == null) {
                this.moveSE();
            } else if (this.getW() == null && this.getSW() == null) {
                this.moveSW();
            }
        } else {
            if (this.getW() == null && this.getSW() == null) {
                this.moveSW();
            } else if (this.getE() == null && this.getSE() == null) {
                this.moveSE();
            }
        }
    }

}
