package ee.mtiidla.headfirst.command;

/**
 * The NoCommand object is an example of a null object. A null object is useful when you
 * don't have a meaningful object to return, and yet you want to remove the responsibility for
 * handling null from the client.It acts as a surrogate and does nothing when its execute method is
 * called.
 */
class NoCommand implements Command {
    @Override
    public void execute() {
        // do nothing
    }

    @Override
    public void undo() {
        // do nothing
    }
}
