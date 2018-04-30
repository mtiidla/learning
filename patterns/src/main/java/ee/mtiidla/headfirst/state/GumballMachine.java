package ee.mtiidla.headfirst.state;

class GumballMachine {

    private State currentState;
    private int count;

    GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            currentState = getNoCoinState();
        } else {
            currentState = getSoldOutState();
        }
    }

    void insertCoin() {
        currentState.insertCoin();
    }

    void ejectCoin() {
        currentState.ejectCoin();
    }

    void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out of the slot...");
        if (count != 0) {
            count--;
        }
    }

    void refill(int count) {
        this.count += count;
        setCurrentState(getNoCoinState());
    }

    void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    State getHasCoinState() {
        return new HasCoinState(this);
    }

    State getNoCoinState() {
        return new NoCoinState(this);
    }

    State getSoldOutState() {
        return new SoldOutState(this);
    }

    State getSoldState() {
        return new SoldState(this);
    }

    State getWinnerState() {
        return new WinnerState(this);
    }

    int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Inventory: " + count + " gumballs\n" + currentState + "\n";
    }
}
