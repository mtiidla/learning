package ee.mtiidla.headfirst.strategy;

class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flying with wings!");
    }
}
