package ee.mtiidla.headfirst.visitor;

interface ShopItem {

    void accept(PriceVisitor visitor);

    int getBasePrice();

}
