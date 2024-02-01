package pixelphysics;

import javax.swing.*;
import java.awt.*;

public class PixelApp {

    static PixelPanel graphics = new PixelPanel();
    static JFrame window = new JFrame("Pubble's Pixel Playground - Version 0.4.1");
    static MouseListener mouse;

    public static void main(String[] args) {
        initWindow();
        gameRun();
    }

    public static void initWindow() {
        mouse = new MouseListener(graphics);
        graphics.addMouseListener(mouse);
        graphics.addMouseWheelListener(mouse);
        graphics.addMouseMotionListener(mouse);
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
        while (true) {
            try {
                Thread.sleep(10);
                graphics.step();
                selectedPixel.setText("Selected: " + mouse.getSelectedPixel());
                selectedPixel.setForeground(Color.WHITE);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

}