package ee.mtiidla.headfirst.command;

class GarageDoorOpenCommand implements Command {

    private final GarageDoor garageDoor;

    GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
        garageDoor.lightOn();
    }

    @Override
    public void undo() {
        garageDoor.down();
        garageDoor.lightOff();
    }
}
