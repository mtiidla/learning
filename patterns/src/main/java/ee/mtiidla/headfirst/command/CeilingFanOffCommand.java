package ee.mtiidla.headfirst.command;

class CeilingFanOffCommand implements Command {

    private final CeilingFan ceilingFan;
    private CeilingFan.FanSpeed prevSpeed;

    CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.setFanSpeed(prevSpeed);
    }
}
