package ee.mtiidla.headfirst.bridge;

/**
 * The Bridge Pattern allows you to vary the implementation and the abstraction by placing the two
 * in separate class hierarchies.
 *
 * The relationship between the RemoteControl (abstraction class hierarchy) and the TV
 * (implementation class hierarchy) is referred to the "bridge".
 */
class BridgeMain {

    public static void main(String[] args) {

        ConcreteRemote sonyControl = new ConcreteRemote(new Sony());
        ConcreteRemote samsungControl = new ConcreteRemote(new Samsung());

        sonyControl.on();
        sonyControl.setChannel(10);
        sonyControl.nextChannel();
        sonyControl.off();

        samsungControl.on();
        samsungControl.setChannel(10);
        samsungControl.previousChannel();
        samsungControl.off();
    }
}
