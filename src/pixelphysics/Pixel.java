package pixelphysics;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Pixel {
    /**
     * Default pixel implementation.
     */

    public static int PIXEL_SIZE = 4;
    public Color c;
    public int x;
    public int y;

    public Pixel(Color c, int x, int y) {
        this.c = c;
        this.x = x / PIXEL_SIZE;
        this.y = y / PIXEL_SIZE;
    }

    public Pixel[][] updatePos(Pixel[][] pixelGrid) {
        int pickDirection = new Random().nextInt(2); // Fall direction search preference

        try {
            if (checkS(pixelGrid)) {
                return this.moveS(pixelGrid);
            }

            switch (pickDirection) {
                case 0: // SE preferred
                    if (this.checkE(pixelGrid) && this.checkSE(pixelGrid)) {
                        return this.moveSE(pixelGrid);
                    } else if (this.checkW(pixelGrid) && this.checkSW(pixelGrid)) {
                        return this.moveSW(pixelGrid);
                    }
                case 1: // SW preferred
                    if (this.checkW(pixelGrid) && this.checkSW(pixelGrid)) {
                        return this.moveSW(pixelGrid);
                    } else if (this.checkE(pixelGrid) && this.checkSE(pixelGrid)) {
                        return this.moveSE(pixelGrid);
                    }
                    break;
            }
        } catch (IndexOutOfBoundsException e) {
            return pixelGrid;
        }

        return pixelGrid;
    }

    protected Pixel[][] moveN(Pixel[][] pixelGrid) {
        if (checkN(pixelGrid)) {
            pixelGrid[this.x][this.y] = null;
            this.y--;
            pixelGrid[this.x][this.y] = this;
        }

        return pixelGrid;
    }

    protected Pixel[][] moveNE(Pixel[][] pixelGrid) {
        if (checkNE(pixelGrid)) {
            pixelGrid[this.x][this.y] = null;
            this.x++;
            this.y--;
            pixelGrid[this.x][this.y] = this;
        }

        return pixelGrid;
    }

    protected Pixel[][] moveE(Pixel[][] pixelGrid) {
        if (checkN(pixelGrid)) {
            pixelGrid[this.x][this.y] = null;
            this.x++;
            pixelGrid[this.x][this.y] = this;
        }

        return pixelGrid;
    }

    protected Pixel[][] moveSE(Pixel[][] pixelGrid) {
        if (this.checkE(pixelGrid) && this.checkSE(pixelGrid)) {
            pixelGrid[this.x][this.y] = null;
            this.x++;
            this.y++;
            pixelGrid[this.x][this.y] = this;
        }

        return pixelGrid;
    }

    protected Pixel[][] moveS(Pixel[][] pixelGrid) {
        if (checkS(pixelGrid)) {
            pixelGrid[this.x][this.y] = null;
            this.y++;
            pixelGrid[this.x][this.y] = this;
        }

        return pixelGrid;
    }

    protected Pixel[][] moveSW(Pixel[][] pixelGrid) {
        if (this.checkW(pixelGrid) && this.checkSW(pixelGrid)) {
            pixelGrid[this.x][this.y] = null;
            this.x--;
            this.y++;
            pixelGrid[this.x][this.y] = this;
        }

        return pixelGrid;
    }

    protected Pixel[][] moveW(Pixel[][] pixelGrid) {
        if (checkW(pixelGrid)) {
            pixelGrid[this.x][this.y] = null;
            this.x--;
            pixelGrid[this.x][this.y] = this;
        }

        return pixelGrid;
    }

    protected Pixel[][] moveNW(Pixel[][] pixelGrid) {
        if (checkN(pixelGrid)) {
            pixelGrid[this.x][this.y] = null;
            this.x--;
            this.y--;
            pixelGrid[this.x][this.y] = this;
        }

        return pixelGrid;
    }

    protected boolean checkN(Pixel[][] pixelGrid) {
        return pixelGrid[this.x][this.y - 1] == null;
    }

    protected boolean checkNE(Pixel[][] pixelGrid) {
        return pixelGrid[this.x + 1][this.y - 1] == null;
    }

    protected boolean checkE(Pixel[][] pixelGrid) {
        return pixelGrid[this.x + 1][this.y] == null;
    }

    protected boolean checkSE(Pixel[][] pixelGrid) {
        return pixelGrid[this.x + 1][this.y + 1] == null;
    }

    protected boolean checkS(Pixel[][] pixelGrid) {
        return this.y < PixelPanel.NUM_PIXELS_VERTICAL - 1 && (pixelGrid[this.x][this.y + 1] == null);
    }

    protected boolean checkSW(Pixel[][] pixelGrid) {
        return pixelGrid[this.x - 1][this.y + 1] == null;
    }

    protected boolean checkW(Pixel[][] pixelGrid) {
        return pixelGrid[this.x - 1][this.y] == null;
    }

    protected boolean checkNW(Pixel[][] pixelGrid) {
        return pixelGrid[this.x - 1][this.y - 1] == null;
    }

    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(this.x * PIXEL_SIZE, this.y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
    }

}
