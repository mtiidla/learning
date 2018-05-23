package ee.mtiidla.headfirst.bridge;

class Sony implements TV {
    @Override
    public void on() {
        System.out.println("Sony TV turned on");
    }

    @Override
    public void off() {
        System.out.println("Sony TV turned off");
    }

    @Override
    public void tuneChannel(int channel) {
        System.out.println("Sony TV tuned to channel " + channel);
    }
}
