package ee.mtiidla.headfirst.builder;

class Dining {

    private final String name;

    public Dining(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dining at " + name;
    }
}
