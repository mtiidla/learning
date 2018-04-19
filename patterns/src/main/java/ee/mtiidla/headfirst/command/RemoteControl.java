package ee.mtiidla.headfirst.command;

class RemoteControl {

    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        int buttonsCount = 7;
        onCommands = new Command[buttonsCount];
        offCommands = new Command[buttonsCount];

        NoCommand noCommand = new NoCommand();
        for (int i = 0; i < buttonsCount; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control ------\n");
        for (int slot = 0; slot < onCommands.length; slot++) {
            sb.append(String.format("[slot %d] %s \t\t %s \n", slot,
                    onCommands[slot].getClass().getSimpleName(),
                    offCommands[slot].getClass().getSimpleName()));
        }
        sb.append("[undo] ").append(undoCommand.getClass().getSimpleName()).append("\n");
        return sb.toString();
    }
}
