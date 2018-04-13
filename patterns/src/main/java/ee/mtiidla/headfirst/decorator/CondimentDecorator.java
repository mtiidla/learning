package ee.mtiidla.headfirst.decorator;

abstract class CondimentDecorator extends Beverage {

    final Beverage beverage;

    CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    public void setSize(Size size) {
        beverage.setSize(size);
    }
}
