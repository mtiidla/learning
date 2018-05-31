package ee.mtiidla.headfirst.builder;

class ParkTickets {

    private final String name;

    public ParkTickets(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tickets to " + name;
    }
}
