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

    public void updatePos() {
        // Movement calls go here
    }

    public void moveN() {
        this.y--;
    }

    public void moveNE() {
        this.x++;
        this.y--;
    }

    public void moveE() {
        this.x++;
    }

    public void moveSE() {
        this.x++;
        this.y++;
    }

    public void moveS() {
        this.y++;
}

    public void moveSW() {
        this.x--;
        this.y++;
    }

    public void moveW() {
        this.x--;
    }

    public void moveNW() {
        this.x--;
        this.y--;
    }

    public Pixel getN() {
        return PixelPanel.pixelGrid[this.x][this.y - 1];
    }

    public Pixel getNE() {
        return PixelPanel.pixelGrid[this.x + 1][this.y - 1];
    }

    public Pixel getE() {
        return PixelPanel.pixelGrid[this.x + 1][this.y];
    }

    public Pixel getSE() {
        return PixelPanel.pixelGrid[this.x + 1][this.y + 1];
    }

    public Pixel getS() {
        return PixelPanel.pixelGrid[this.x][this.y + 1];
    }

    public Pixel getSW() {
        return PixelPanel.pixelGrid[this.x - 1][this.y + 1];
    }

    public Pixel getW() {
        return PixelPanel.pixelGrid[this.x - 1][this.y];
    }

    public Pixel getNW() {
        return PixelPanel.pixelGrid[this.x - 1][this.y - 1];
    }

    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(this.x * PixelPanel.PIXEL_SIZE, this.y * PixelPanel.PIXEL_SIZE, PixelPanel.PIXEL_SIZE, PixelPanel.PIXEL_SIZE);
    }

}
