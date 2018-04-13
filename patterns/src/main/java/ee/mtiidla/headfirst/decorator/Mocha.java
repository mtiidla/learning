package ee.mtiidla.headfirst.decorator;

class Mocha extends CondimentDecorator {

    protected Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
