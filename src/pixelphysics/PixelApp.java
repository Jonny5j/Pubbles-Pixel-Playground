package pixelphysics;

import solids.Sand;

import javax.swing.*;
import java.awt.*;

public class PixelApp {

    static PixelPanel graphics = new PixelPanel();
    static JFrame window = new JFrame("Pubble's Pixel Physics - Version 0.2.3");

    public static void main(String[] args) {
        initWindow();
        gameRun();
    }

    public static void initWindow() {
        graphics.addMouseListener(new MouseListener(graphics));
        graphics.setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setContentPane(graphics);
        window.pack();
        window.setVisible(true);
    }

    public static void gameRun() {
//        int i = 0;
        while (true) {
//            if (i % 5 == 0) {
//                graphics.addPixel(new Sand(graphics.getWidth() / 2, 0));
//            }
            try {
                Thread.sleep(10);
                graphics.step();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
//            i++;
        }
    }

}