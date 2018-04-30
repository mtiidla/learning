package ee.mtiidla.headfirst.state;

class SoldOutState implements State {

    private final GumballMachine gumballMachine;

    SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You cannot insert coin, machine is sold out");
    }

    @Override
    public void ejectCoin() {
        System.out.println("You can't eject, there is no coin inserted");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there were no gumballs left...");
    }

    @Override
    public void dispense() {
        System.out.println("No gumballs to dispense");
    }

    @Override
    public String toString() {
        return "Machine is sold out";
    }
}
