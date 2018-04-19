package ee.mtiidla.headfirst.command;

class GarageDoorCloseCommand implements Command {

    private final GarageDoor garageDoor;

    GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
        garageDoor.lightOff();
    }

    @Override
    public void undo() {
        garageDoor.up();
        garageDoor.lightOn();
    }
}
