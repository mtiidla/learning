package ee.mtiidla.headfirst.command;

class CeilingFanLowCommand implements Command {

    private final CeilingFan ceilingFan;
    private CeilingFan.FanSpeed prevSpeed;

    CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }

    @Override
    public void undo() {
        ceilingFan.setFanSpeed(prevSpeed);
    }
}
