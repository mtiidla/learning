package ee.mtiidla.headfirst.bridge;

/**
 * Concrete subclasses are implemented in terms of the abstraction, NOT implementation.
 * (As if ConcreteRemote implemented RemoteControl, not extended it)
 */
class ConcreteRemote extends RemoteControl {

    private int currentChannel;

    protected ConcreteRemote(TV implementor) {
        super(implementor);
    }

    @Override
    void setChannel(int channel) {
        super.setChannel(channel);
        currentChannel = channel;
    }

    void nextChannel() {
        setChannel(currentChannel + 1);
    }

    void previousChannel() {
        setChannel(currentChannel - 1);
    }

}
