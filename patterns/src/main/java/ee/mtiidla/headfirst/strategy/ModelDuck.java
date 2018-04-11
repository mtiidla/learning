package ee.mtiidla.headfirst.strategy;

class ModelDuck extends Duck {

    ModelDuck() {
        mFlyBehavior = new FlyNoWay();
        mQuackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
