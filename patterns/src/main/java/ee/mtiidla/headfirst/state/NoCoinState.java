package ee.mtiidla.headfirst.state;

class NoCoinState implements State {

    private final GumballMachine gumballMachine;

    NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You inserted a coin");
        gumballMachine.setCurrentState(gumballMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("You haven't inserted a coin");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is no coin");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    public String toString() {
        return "Machine is waiting for a coin";
    }
}
