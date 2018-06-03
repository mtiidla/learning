package ee.mtiidla.headfirst.visitor;

class Book implements ShopItem {

    private final int weight;
    private final int pageCount;

    public Book(int weight, int pageCount) {
        this.weight = weight;
        this.pageCount = pageCount;
    }

    @Override
    public void accept(PriceVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getBasePrice() {
        return 15;
    }

    public int getWeight() {
        return weight;
    }

    public int getPageCount() {
        return pageCount;
    }
}
