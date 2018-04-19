package ee.mtiidla.headfirst.command;

class RemoteControlUndoTest {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light("Living Room");

        remoteControl.setCommand(0,
                new LightOnCommand(light),
                new LightOffCommand(light));

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }

}
