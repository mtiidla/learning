package ee.mtiidla.headfirst.command;

class CeilingFanOnCommand implements Command {

    private final CeilingFan ceilingFan;

    CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.high();
    }

    @Override
    public void undo() {
        ceilingFan.off();
    }
}
