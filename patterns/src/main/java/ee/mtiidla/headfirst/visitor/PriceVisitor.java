package ee.mtiidla.headfirst.visitor;

interface PriceVisitor {

    void visit(Dictionary dictionary);

    void visit(Book book);

    void visit(Magazine magazine);

    void visit(Flowers flowers);

    float getTotalPrice();
}
