package ee.mtiidla.headfirst.bridge;

class Samsung implements TV {
    @Override
    public void on() {
        System.out.println("Samsung TV turned on");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV turned off");
    }

    @Override
    public void tuneChannel(int channel) {
        System.out.println("Samsung TV tuned to channel " + channel);
    }
}
