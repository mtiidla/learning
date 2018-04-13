package ee.mtiidla.headfirst.decorator;

class DarkRoast extends Beverage {

    protected DarkRoast() {
        this.description = "Dark roast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
