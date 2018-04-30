package ee.mtiidla.headfirst.state;

import java.util.Random;

class HasCoinState implements State {

    private final Random randomWinner = new Random();
    private final GumballMachine gumballMachine;

    HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You cannot insert another coin");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned");
        gumballMachine.setCurrentState(gumballMachine.getNoCoinState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if (winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setCurrentState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setCurrentState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public String toString() {
        return "Machine has a coin inserted";
    }
}
