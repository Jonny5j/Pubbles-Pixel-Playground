package elements;

import pixelphysics.PixelPanel;

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

    public Pixel[][] step(Pixel[][] grid) {
        // Insert movements
        return grid;
    }

    public Pixel[][] moveN(Pixel[][] grid) {
        grid[this.x][this.y] = null;
        this.y--;
        grid[this.x][this.y] = this;
        return grid;
    }

    public Pixel[][] moveNE(Pixel[][] grid) {
        grid[this.x][this.y] = null;
        this.x++;
        this.y--;
        grid[this.x][this.y] = this;
        return grid;
    }

    public Pixel[][] moveE(Pixel[][] grid) {
        grid[this.x][this.y] = null;
        this.x++;
        grid[this.x][this.y] = this;
        return grid;
    }

    public Pixel[][] moveSE(Pixel[][] grid) {
        grid[this.x][this.y] = null;
        this.x++;
        this.y++;
        grid[this.x][this.y] = this;
        return grid;
    }

    public Pixel[][] moveS(Pixel[][] grid) {
        grid[this.x][this.y] = null;
        this.y++;
        grid[this.x][this.y] = this;
        return grid;
    }

    public Pixel[][] moveSW(Pixel[][] grid) {
        grid[this.x][this.y] = null;
        this.x--;
        this.y++;
        grid[this.x][this.y] = this;
        return grid;
    }

    public Pixel[][] moveW(Pixel[][] grid) {
        grid[this.x][this.y] = null;
        this.x--;
        grid[this.x][this.y] = this;
        return grid;
    }

    public Pixel[][] moveNW(Pixel[][] grid) {
        grid[this.x][this.y] = null;
        this.x--;
        this.y--;
        grid[this.x][this.y] = this;
        return grid;
    }

    public Pixel[][] swapPixels(Pixel other, Pixel[][] grid) {
        grid[this.x][this.y] = other;
        int tempX = other.x;
        int tempY = other.y;
        other.x = this.x;
        other.y = this.y;
        this.x = tempX;
        this.y = tempY;
        grid[this.x][this.y] = this;
        return grid;
    }

    public Pixel getN(Pixel[][] grid) {
        return grid[this.x][this.y - 1];
    }

    public Pixel getNE(Pixel[][] grid) {
        return grid[this.x + 1][this.y - 1];
    }

    public Pixel getE(Pixel[][] grid) {
        return grid[this.x + 1][this.y];
    }

    public Pixel getSE(Pixel[][] grid) {
        return grid[this.x + 1][this.y + 1];
    }

    public Pixel getS(Pixel[][] grid) {
        return grid[this.x][this.y + 1];
    }

    public Pixel getSW(Pixel[][] grid) {
        return grid[this.x - 1][this.y + 1];
    }

    public Pixel getW(Pixel[][] grid) {
        return grid[this.x - 1][this.y];
    }

    public Pixel getNW(Pixel[][] grid) {
        return grid[this.x - 1][this.y - 1];
    }

    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(this.x * PixelPanel.PIXEL_SIZE, this.y * PixelPanel.PIXEL_SIZE, PixelPanel.PIXEL_SIZE, PixelPanel.PIXEL_SIZE);
    }

}
