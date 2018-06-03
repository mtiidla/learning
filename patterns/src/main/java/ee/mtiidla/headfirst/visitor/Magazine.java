package ee.mtiidla.headfirst.visitor;

class Magazine implements ShopItem {

    private final float popularity;

    Magazine(float popularity) {
        this.popularity = popularity;
    }

    @Override
    public void accept(PriceVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getBasePrice() {
        return 10;
    }

    public float getPopularity() {
        return popularity;
    }
}
