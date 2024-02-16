package liquids;

import pixelphysics.Pixel;
import pixelphysics.PixelPanel;

import java.awt.*;
import java.util.Random;

public class Liquid extends Pixel {

    public Liquid(Color c, int x, int y) {
        super(c, x, y);
    }

    @Override
    public void updatePos() {
        try {
            if(this.y < PixelPanel.numPixelsVertical - 1 && getS() == null) {
                this.moveS();
            } else {
                this.moveRandom();
            }
        } catch (IndexOutOfBoundsException ignored) {}
    }

    public void moveRandom() {
        if (new Random().nextBoolean()) { // E preferred
            if (this.getE() == null) {
                this.moveE();
            } else if (this.getW() == null) {
                this.moveW();
            }
        } else { // W preferred
            if (this.getW() == null) {
                this.moveW();
            } else if (this.getE() == null) {
                this.moveE();
            }
        }
    }

}
