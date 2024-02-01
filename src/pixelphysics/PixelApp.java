package pixelphysics;

import solids.Sand;

import javax.swing.*;
import java.awt.*;

public class PixelApp {

    static PixelPanel graphics = new PixelPanel();
    static JFrame window = new JFrame("Pubble's Pixel Playground - Version 0.2.4");
    static MouseListener mouse;

    public static void main(String[] args) {
        initWindow();
        gameRun();
    }

    public static void initWindow() {
        mouse = new MouseListener(graphics);
        graphics.addMouseListener(mouse);
        graphics.setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setContentPane(graphics);
        window.pack();
        window.setVisible(true);
    }

    public static void gameRun() {
        JLabel selectedPixel = new JLabel("Selected: " + mouse.getSelectedPixel());
        graphics.add(selectedPixel);
//        int i = 0;
        while (true) {
//            if (i % 5 == 0) {
//                graphics.addPixel(new Sand(graphics.getWidth() / 2, 0));
//            }
            try {
                Thread.sleep(10);
                graphics.step();
                selectedPixel.setText("Selected: " + mouse.getSelectedPixel());
                selectedPixel.setForeground(Color.WHITE);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
//            i++;
        }
    }

}