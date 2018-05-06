package ee.mtiidla.headfirst.compound;

class GooseFactory extends AbstractGooseFactory {
    @Override
    Quackable createGoose() {
        return new GooseAdapter(new Goose());
    }
}
