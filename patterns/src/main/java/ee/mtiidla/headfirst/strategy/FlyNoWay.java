package ee.mtiidla.headfirst.strategy;

class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Cannot fly!");
    }
}
