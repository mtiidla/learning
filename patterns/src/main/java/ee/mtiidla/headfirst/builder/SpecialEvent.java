package ee.mtiidla.headfirst.builder;

class SpecialEvent {

    private final String name;

    public SpecialEvent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Special event " + name;
    }
}
