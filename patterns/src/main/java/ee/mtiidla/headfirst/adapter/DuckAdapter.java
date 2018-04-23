package ee.mtiidla.headfirst.adapter;

import java.util.Random;

class DuckAdapter implements Turkey {

    private final Random random;
    private final Duck duck;

    DuckAdapter(Duck duck) {
        this.duck = duck;
        random = new Random();
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        if (random.nextInt(5) == 0) {
            duck.fly();
        }
    }
}
