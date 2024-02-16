package solids;

import pixelphysics.Pixel;
import pixelphysics.PixelPanel;

import java.awt.*;

public class Sand extends FallingSolid {

    public Sand(int x, int y) {
        super(Color.YELLOW, x, y);
    }

    @Override
    public void updatePos() {
        try {
            if (getS() == null) {
                this.moveS();
            } else if (getS().getClass().getPackageName().equals("liquids")) {
                this.swapS();
            } else {
                this.moveRandom();
            }
        } catch (IndexOutOfBoundsException ignored) {}
    }

    private void swapS() {
        Pixel other = PixelPanel.pixelGrid[this.x][this.y + 1];
        other.y--;
        this.y++;
    }


}
