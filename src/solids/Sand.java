package solids;

import liquids.Water;
import pixelphysics.Pixel;

import java.awt.*;

public class Sand extends Pixel {

    public Sand(int x, int y) {
        super(Color.YELLOW, x, y);
    }

    @Override
    protected boolean checkS(Pixel[][] pixelGrid) {
        return pixelGrid[this.x][this.y + 1] == null || pixelGrid[this.x][this.y + 1].getClass().getPackage().getName().equals("liquids");
    }


}
