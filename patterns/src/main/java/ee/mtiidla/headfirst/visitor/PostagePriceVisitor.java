package ee.mtiidla.headfirst.visitor;

class PostagePriceVisitor implements PriceVisitor {

    private float totalPrice;

    @Override
    public void visit(Dictionary dictionary) {
        totalPrice += dictionary.getBasePrice() + dictionary.getPageCount() * 0.05;
    }

    @Override
    public void visit(Book book) {
        totalPrice += book.getBasePrice() + book.getWeight() * 0.2;
    }

    @Override
    public void visit(Magazine magazine) {
        totalPrice += magazine.getBasePrice() + 3;
    }

    @Override
    public void visit(Flowers flowers) {
        totalPrice += flowers.getBasePrice() + flowers.getSizeOfBucket() * 1.1;
    }

    @Override
    public float getTotalPrice() {
        return totalPrice;
    }
}
