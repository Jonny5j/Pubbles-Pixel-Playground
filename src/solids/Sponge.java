package solids;

import pixelphysics.Pixel;

import java.awt.*;

public class Sponge extends FloatingSolid {

    public Sponge(int x, int y) {
        super(Color.GREEN, x, y);
    }

    @Override
    public Pixel[][] updatePos(Pixel[][] pixelGrid) {
        if (this.getN(pixelGrid) != null && this.getN(pixelGrid).getClass().getName().equals("Water")) {
            pixelGrid[this.x][this.y - 1] = null;
            return pixelGrid;
        }
        if (this.getNE(pixelGrid) != null && this.getNE(pixelGrid).getClass().getName().equals("Water")) {
            pixelGrid[this.x + 1][this.y - 1] = null;
            return pixelGrid;
        }
        if (this.getE(pixelGrid) != null && this.getE(pixelGrid).getClass().getName().equals("Water")) {
            pixelGrid[this.x + 1][this.y - 1] = null;
            return pixelGrid;
        }
        if (this.getSE(pixelGrid) != null && this.getSE(pixelGrid).getClass().getName().equals("Water")) {
            pixelGrid[this.x + 1][this.y + 1] = null;
            return pixelGrid;
        }
        if (this.getS(pixelGrid) != null && this.getS(pixelGrid).getClass().getName().equals("Water")) {
            pixelGrid[this.x][this.y + 1] = null;
            return pixelGrid;
        }
        if (this.getSW(pixelGrid) != null && this.getSW(pixelGrid).getClass().getName().equals("Water")) {
            pixelGrid[this.x - 1][this.y + 1] = null;
            return pixelGrid;
        }
        if (this.getW(pixelGrid) != null && this.getW(pixelGrid).getClass().getName().equals("Water")) {
            pixelGrid[this.x - 1][this.y] = null;
            return pixelGrid;
        }
        if (this.getNW(pixelGrid) != null && this.getNW(pixelGrid).getClass().getName().equals("Water")) {
            pixelGrid[this.x - 1][this.y - 1] = null;
            return pixelGrid;
        }

        return pixelGrid;
    }
}
