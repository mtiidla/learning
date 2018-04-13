package ee.mtiidla.headfirst.decorator;

class Whip extends CondimentDecorator {

    Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
