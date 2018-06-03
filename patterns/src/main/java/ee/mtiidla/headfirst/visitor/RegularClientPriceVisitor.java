package ee.mtiidla.headfirst.visitor;

class RegularClientPriceVisitor implements PriceVisitor {

    private float totalPrice;

    @Override
    public void visit(Dictionary dictionary) {
        totalPrice += dictionary.getBasePrice();
    }

    @Override
    public void visit(Book book) {
        totalPrice += book.getBasePrice();
    }

    @Override
    public void visit(Magazine magazine) {
        totalPrice += magazine.getBasePrice() * magazine.getPopularity();
    }

    @Override
    public void visit(Flowers flowers) {
        totalPrice += flowers.getBasePrice();
    }

    @Override
    public float getTotalPrice() {
        return totalPrice;
    }
}
