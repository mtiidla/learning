package ee.mtiidla.headfirst.decorator;

class HouseBlend extends Beverage {

    protected HouseBlend() {
        description = "House blend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
