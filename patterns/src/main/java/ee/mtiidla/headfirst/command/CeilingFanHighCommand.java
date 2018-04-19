package ee.mtiidla.headfirst.command;

class CeilingFanHighCommand implements Command {

    private final CeilingFan ceilingFan;
    private CeilingFan.FanSpeed prevSpeed;

    CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        ceilingFan.setFanSpeed(prevSpeed);
    }
}
