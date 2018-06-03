package ee.mtiidla.headfirst.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * The Visitor Pattern can be used when you want to add capabilities to a composite of objects and
 * encapsulation is not important.
 *
 * It allows for one or more operation to be applied to a set of objects at runtime, decoupling the
 * operations from the object structure.
 *
 * In this case, the interface for ShopItem is very stable and we do not want to alter it for
 * different price calculations. Instead we introduce the accept(Visitor) method and add as many
 * visitors as we want while minimizing the changes to the ShopItem interface.
 */
class VisitorClient {

    public static void main(String[] args) {

        List<ShopItem> cart = new ArrayList<>();
        cart.add(new Book(2, 400));
        cart.add(new Magazine(0.8f));
        cart.add(new Flowers(10));
        cart.add(new Dictionary(3, 800));

        PriceVisitor regularClientPriceVisitor = new RegularClientPriceVisitor();
        PriceVisitor postagePriceVisitor = new PostagePriceVisitor();

        for (ShopItem shopItem : cart) {
            shopItem.accept(regularClientPriceVisitor);
            shopItem.accept(postagePriceVisitor);
        }

        System.out.println("Regular client price $ " + regularClientPriceVisitor.getTotalPrice());
        System.out.println("Postage price $ " + postagePriceVisitor.getTotalPrice());

    }

}
