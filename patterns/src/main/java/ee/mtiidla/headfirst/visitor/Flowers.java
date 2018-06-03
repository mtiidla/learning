package ee.mtiidla.headfirst.visitor;

class Flowers implements ShopItem {

    private final int sizeOfBucket;

    public Flowers(int sizeOfBucket) {
        this.sizeOfBucket = sizeOfBucket;
    }

    @Override
    public void accept(PriceVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getBasePrice() {
        return sizeOfBucket * 2;
    }

    public int getSizeOfBucket() {
        return sizeOfBucket;
    }
}
