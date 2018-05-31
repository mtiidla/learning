package ee.mtiidla.headfirst.builder;

class Hotel {

    private final String name;

    public Hotel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hotel " + name;
    }
}
