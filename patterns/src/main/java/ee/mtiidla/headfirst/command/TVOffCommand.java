package ee.mtiidla.headfirst.command;

class TVOffCommand implements Command {

    private final TV tv;

    TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
