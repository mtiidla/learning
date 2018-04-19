package ee.mtiidla.headfirst.command;

class TVOnCommand implements Command {

    private final TV tv;

    TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
