package ee.mtiidla.headfirst.state;

/**
 * The State Pattern allows an object to alter its behavior when its internal state changes. The
 * object will appear to change its class.
 */
class GumballMachineTest {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

    }

}
