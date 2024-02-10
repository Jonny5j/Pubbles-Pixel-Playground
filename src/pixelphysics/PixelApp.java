package pixelphysics;

import javax.swing.*;
import java.awt.*;

public class PixelApp implements Runnable {

    public PixelPanel panel;
    public JFrame window = new JFrame("Pubble's Pixel Playground - Version 0.6");
    public MouseListener mouse;
    public final double TPS = 60.0; // Ticks Per Second (should also be FPS)

    public static void main(String[] args) {
        Thread t = new Thread(new PixelApp());
        t.start();
    }

    @Override
    public void run() {
        initWindow();


        JLabel selectedPixel = new JLabel("Selected: " + mouse.getSelectedPixel());
        selectedPixel.setForeground(Color.WHITE);
        this.panel.add(selectedPixel);

        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / this.TPS;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                selectedPixel.setText("Selected: " + mouse.getSelectedPixel());
                this.panel.step();

                delta--;
            }
        }
    }

    public void initWindow() {
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        this.panel = new PixelPanel(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight());
        this.mouse = new MouseListener(this.panel);
        this.panel.addMouseListener(this.mouse);
        this.panel.addMouseWheelListener(this.mouse);
        this.panel.addMouseMotionListener(this.mouse);
        this.panel.setBackground(Color.BLACK);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setResizable(false);
        this.window.setContentPane(this.panel);
        this.window.pack();
        device.setFullScreenWindow(this.window);
        this.window.setVisible(true);
    }

}