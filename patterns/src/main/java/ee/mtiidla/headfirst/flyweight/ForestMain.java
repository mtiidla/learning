package ee.mtiidla.headfirst.flyweight;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Flyweight is a structural design pattern that lets you fit more objects into the available amount
 * of RAM by sharing common parts of object state among multiple objects, instead of keeping it in
 * each object.
 */
class ForestMain {

    public static void main(String[] args) {
        JFrame frame = buildFrame();

        final BufferedImage image = getBufferedImage();
        TreeManager treeManager = new TreeManager(10000);

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                treeManager.displayTrees(g, image);
            }
        };


        frame.add(pane);
        frame.revalidate();

    }

    private static BufferedImage getBufferedImage() {
        InputStream resource = Hello.class.getClassLoader().getResourceAsStream("tree.jpg");
        try {
            return ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        return frame;
    }

    private static class Hello {

    }

}
