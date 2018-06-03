package ee.mtiidla.headfirst.visitor;

class Dictionary extends Book {

    public Dictionary(int weight, int pageCount) {
        super(weight, pageCount);
    }

    @Override
    public void accept(PriceVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getBasePrice() {
        return 30;
    }
}
