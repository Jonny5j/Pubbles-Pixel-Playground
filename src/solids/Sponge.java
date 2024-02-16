package solids;

import pixelphysics.PixelPanel;

import java.awt.*;

public class Sponge extends FloatingSolid {

    public Sponge(int x, int y) {
        super(Color.GREEN, x, y);
    }

    @Override
    public void updatePos() {
        try {
            if (this.getN().getClass().getName().equals("Water")) {
                PixelPanel.removePixel(this.x, this.y - 1);
                System.out.println("hi");
            }
        } catch (NullPointerException ignored) {}
    }

}
