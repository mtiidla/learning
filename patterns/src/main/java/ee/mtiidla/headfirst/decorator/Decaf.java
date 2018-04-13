package ee.mtiidla.headfirst.decorator;

class Decaf extends Beverage {

    protected Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
