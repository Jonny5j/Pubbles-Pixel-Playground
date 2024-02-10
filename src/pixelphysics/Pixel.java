package pixelphysics;

import java.awt.*;

public class Pixel {
    /**
     * Default pixel implementation. Can check surroundings and move. Also controls display size.
     */

    public Color c;
    public int x;
    public int y;

    public Pixel(Color c, int x, int y) {
        this.c = c;
        this.x = x / PixelPanel.PIXEL_SIZE;
        this.y = y / PixelPanel.PIXEL_SIZE;
    }

    public Pixel[][] updatePos(Pixel[][] pixelGrid) {
        return pixelGrid;
    }

    public Pixel[][] moveN(Pixel[][] pixelGrid) {
        pixelGrid[this.x][this.y] = null;
        this.y--;
        pixelGrid[this.x][this.y] = this;

        return pixelGrid;
    }

    public Pixel[][] moveNE(Pixel[][] pixelGrid) {
        pixelGrid[this.x][this.y] = null;
        this.x++;
        this.y--;
        pixelGrid[this.x][this.y] = this;

        return pixelGrid;
    }

    public Pixel[][] moveE(Pixel[][] pixelGrid) {
        pixelGrid[this.x][this.y] = null;
        this.x++;
        pixelGrid[this.x][this.y] = this;

        return pixelGrid;
    }

    public Pixel[][] moveSE(Pixel[][] pixelGrid) {
        pixelGrid[this.x][this.y] = null;
        this.x++;
        this.y++;
        pixelGrid[this.x][this.y] = this;

        return pixelGrid;
    }

    public Pixel[][] moveS(Pixel[][] pixelGrid) {
        pixelGrid[this.x][this.y] = null;
        this.y++;
        pixelGrid[this.x][this.y] = this;

        return pixelGrid;
    }

    public Pixel[][] moveSW(Pixel[][] pixelGrid) {
        pixelGrid[this.x][this.y] = null;
        this.x--;
        this.y++;
        pixelGrid[this.x][this.y] = this;

        return pixelGrid;
    }

    public Pixel[][] moveW(Pixel[][] pixelGrid) {
        pixelGrid[this.x][this.y] = null;
        this.x--;
        pixelGrid[this.x][this.y] = this;

        return pixelGrid;
    }

    public Pixel[][] moveNW(Pixel[][] pixelGrid) {
        pixelGrid[this.x][this.y] = null;
        this.x--;
        this.y--;
        pixelGrid[this.x][this.y] = this;

        return pixelGrid;
    }

    public Pixel getN(Pixel[][] pixelGrid) {
        return pixelGrid[this.x][this.y - 1];
    }

    public Pixel getNE(Pixel[][] pixelGrid) {
        return pixelGrid[this.x + 1][this.y - 1];
    }

    public Pixel getE(Pixel[][] pixelGrid) {
        return pixelGrid[this.x + 1][this.y];
    }

    public Pixel getSE(Pixel[][] pixelGrid) {
        return pixelGrid[this.x + 1][this.y + 1];
    }

    public Pixel getS(Pixel[][] pixelGrid) {
        return pixelGrid[this.x][this.y + 1];
    }

    public Pixel getSW(Pixel[][] pixelGrid) {
        return pixelGrid[this.x - 1][this.y + 1];
    }

    public Pixel getW(Pixel[][] pixelGrid) {
        return pixelGrid[this.x - 1][this.y];
    }

    public Pixel getNW(Pixel[][] pixelGrid) {
        return pixelGrid[this.x - 1][this.y - 1];
    }

    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(this.x * PixelPanel.PIXEL_SIZE, this.y * PixelPanel.PIXEL_SIZE, PixelPanel.PIXEL_SIZE, PixelPanel.PIXEL_SIZE);
    }

}
