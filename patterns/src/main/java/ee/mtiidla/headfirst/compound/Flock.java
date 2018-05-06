package ee.mtiidla.headfirst.compound;

import java.util.ArrayList;
import java.util.List;

class Flock implements Quackable {

    private final List<Quackable> quackables = new ArrayList<>();

    void add(Quackable quackable) {
        quackables.add(quackable);
    }

    @Override
    public void quack() {
        for (Quackable quackable : quackables) {
            quackable.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        for (Quackable quackable : quackables) {
            quackable.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
    }
}
