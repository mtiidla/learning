package ee.mtiidla.headfirst.decorator;

class Espresso extends Beverage {

    protected Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
