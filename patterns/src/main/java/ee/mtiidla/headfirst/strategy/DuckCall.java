package ee.mtiidla.headfirst.strategy;

class DuckCall {

    QuackBehavior mQuackBehavior;

    public DuckCall() {
        mQuackBehavior = new Quack();
    }

    public void fakeQuack() {
        mQuackBehavior.quack();
    }
}
