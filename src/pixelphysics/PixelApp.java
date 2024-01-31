package pixelphysics;

import java.awt.Color;
import javax.swing.JFrame;

public class PixelApp {

    static PixelPanel graphics = new PixelPanel();
    static JFrame window = new JFrame("Pixel Physics - Version 0.1");

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
       while (true) {
            try {
                Thread.sleep(10);
                graphics.step();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

}