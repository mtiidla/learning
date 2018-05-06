package ee.mtiidla.headfirst.compound;

class CountingGooseFactory extends AbstractGooseFactory {
    @Override
    Quackable createGoose() {
        return new QuackCounter(new GooseAdapter(new Goose()));
    }
}
