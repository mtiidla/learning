package ee.mtiidla.headfirst.bridge;

/**
 * All methods in the abstraction are implemented in terms of the implementation.
 * (As if TV would directly implement from RemoteControl)
 */
abstract class RemoteControl {

    private final TV implementor;

    protected RemoteControl(TV implementor) {
        this.implementor = implementor;
    }

    void on() {
        implementor.on();
    }

    void off() {
        implementor.off();
    }

    void setChannel(int channel) {
        implementor.tuneChannel(channel);
    }

}
