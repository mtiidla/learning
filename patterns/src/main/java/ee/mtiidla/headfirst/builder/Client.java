package ee.mtiidla.headfirst.builder;

class Client {

    private final String name;
    private final Vacation vacation;

    public Client(String name, Vacation vacation) {
        this.name = name;
        this.vacation = vacation;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " vacation: " + vacation.toString();
    }
}
