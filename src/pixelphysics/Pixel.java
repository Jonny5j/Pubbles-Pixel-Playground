package pixelphysics;

import java.awt.Color;
import java.awt.Graphics;

public class Pixel {

    public static int PIXEL_SIZE = 4;
    public Color c;
    public int x;
    public int y;

    public Pixel(Color c, int x, int y) {
        this.c = c;
        this.x = x / PIXEL_SIZE;
        this.y = y / PIXEL_SIZE;
    }

    public void fallDown() {
        this.y++;
    }

    public void fallLeft() {
        this.x--;
        fallDown();
    }
    
    public void fallRight() {
        this.x++;
        fallDown();
    }

    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(this.x * PIXEL_SIZE, this.y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
    }
    
}
