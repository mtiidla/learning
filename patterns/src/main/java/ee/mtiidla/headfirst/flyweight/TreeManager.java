package ee.mtiidla.headfirst.flyweight;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

class TreeManager {

    private int[] xCoordinates;
    private int[] yCoordinates;
    private final Random random = new Random();

    public TreeManager(int numberOfTrees) {
        xCoordinates = new int[numberOfTrees];
        yCoordinates = new int[numberOfTrees];
        for (int i = 0; i < numberOfTrees; i++) {
            xCoordinates[i] = random.nextInt(900);
            yCoordinates[i] = random.nextInt(500);
        }
    }

    // instead of creating millions of tree objects with memory heavy image and unique
    // coordinates, create only one tree object and store coordinates separately
    // (example is fake since image is passed as a reference and thus always would have a single instance)
    public void displayTrees(Graphics graphics, Image image) {
        Tree tree = new Tree(image);
        for (int i = 0; i < xCoordinates.length; i++) {
            tree.display(graphics, xCoordinates[i], yCoordinates[i]);
        }
    }
}
