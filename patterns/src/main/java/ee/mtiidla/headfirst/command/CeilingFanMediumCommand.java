package ee.mtiidla.headfirst.command;

class CeilingFanMediumCommand implements Command {

    private final CeilingFan ceilingFan;
    private CeilingFan.FanSpeed prevSpeed;

    CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
    }

    @Override
    public void undo() {
        ceilingFan.setFanSpeed(prevSpeed);
    }
}
