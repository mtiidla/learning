package ee.mtiidla.headfirst.command;

class HottubOnCommand implements Command {

    private final Hottub hottub;

    HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.on();
    }

    @Override
    public void undo() {
        hottub.off();
    }
}
