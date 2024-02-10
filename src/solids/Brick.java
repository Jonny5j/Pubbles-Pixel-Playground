package solids;

import pixelphysics.Pixel;

import java.awt.*;

public class Brick extends FloatingSolid {

    public Brick(int x, int y) {
        super(Color.RED, x, y);
    }

    @Override
    public Pixel[][] updatePos(Pixel[][] pixelGrid) {
        return pixelGrid;
    }

}
