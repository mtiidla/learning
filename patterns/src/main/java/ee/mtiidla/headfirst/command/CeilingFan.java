package ee.mtiidla.headfirst.command;

class CeilingFan {

    private final String location;
    private FanSpeed fanSpeed = FanSpeed.OFF;

    CeilingFan(String location) {
        this.location = location;
    }

    void high() {
        setFanSpeed(FanSpeed.HIGH);
    }

    void medium() {
        setFanSpeed(FanSpeed.MEDIUM);
    }

    void low() {
        setFanSpeed(FanSpeed.LOW);
    }

    void off() {
        setFanSpeed(FanSpeed.OFF);
    }

    FanSpeed getSpeed() {
        return fanSpeed;
    }

    void setFanSpeed(FanSpeed fanSpeed) {
        this.fanSpeed = fanSpeed;
        System.out.println(location + " fan speed set to " + fanSpeed);
    }

    enum FanSpeed {
        HIGH, MEDIUM, LOW, OFF
    }

}
