package ee.mtiidla.headfirst.command;

class RemoteControlStateUndoTest {

    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        remoteControl.setCommand(0,
                new CeilingFanMediumCommand(ceilingFan),
                new CeilingFanOffCommand(ceilingFan));

        remoteControl.setCommand(1,
                new CeilingFanHighCommand(ceilingFan),
                new CeilingFanOffCommand(ceilingFan));

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }


}
