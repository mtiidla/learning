package ee.mtiidla.headfirst.decorator;

class Soy extends CondimentDecorator {

    Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return costBySize(getSize()) + beverage.cost();
    }

    private double costBySize(Size size) {
        switch (size) {
            case SMALL:
        		return 0.10;
            case MEDIUM:
                return 0.15;
            case LARGE:
                return 0.20;
        }
        throw new IllegalArgumentException("Unknown size");
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
