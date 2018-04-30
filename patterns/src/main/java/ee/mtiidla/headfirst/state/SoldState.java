package ee.mtiidla.headfirst.state;

class SoldState implements State {

    private final GumballMachine gumballMachine;

    SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, we're already dispensing");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't give you another gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setCurrentState(gumballMachine.getNoCoinState());
        } else {
            System.out.println("Oops, out of gumballs");
            gumballMachine.setCurrentState(gumballMachine.getSoldOutState());
        }
    }

    @Override
    public String toString() {
        return "Machine is dispensing";
    }
}
