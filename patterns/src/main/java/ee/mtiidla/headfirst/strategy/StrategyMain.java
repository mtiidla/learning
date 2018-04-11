package ee.mtiidla.headfirst.strategy;

/**
 * The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them
 * interchangeable. Strategy lets the algorithm vary independently from clients that use it.
 */
public class StrategyMain {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

        DuckCall fakeDuck = new DuckCall();
        fakeDuck.fakeQuack();

    }

}
