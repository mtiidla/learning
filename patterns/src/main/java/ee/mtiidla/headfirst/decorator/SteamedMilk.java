package ee.mtiidla.headfirst.decorator;

class SteamedMilk extends CondimentDecorator {

    SteamedMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Steamed milk";
    }
}
