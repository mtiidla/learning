package ee.mtiidla.headfirst.strategy;

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
