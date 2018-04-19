package ee.mtiidla.headfirst.command;

class HottubOffCommand implements Command {

    private final Hottub hottub;

    HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.off();
    }

    @Override
    public void undo() {
        hottub.on();
    }
}
