package ee.mtiidla.headfirst.flyweight;

import java.awt.Graphics;
import java.awt.Image;

class Tree {

    // image is memory heavy intrinsic state that would not change between instances
    private final Image image;

    Tree(Image image) {
        this.image = image;
    }

    // x and y coordinates are unique for each tree (extrinsic state)
    public void display(Graphics graphics, int x, int y) {
        graphics.drawImage(image, x, y, null);
    }
}
