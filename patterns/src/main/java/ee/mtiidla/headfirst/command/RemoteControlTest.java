package ee.mtiidla.headfirst.command;

/**
 * The Command Pattern encapsulates a request as an object, thereby letting you parameterize other
 * objects with different requests, queue or log requests and support undoable operations.
 */
class RemoteControlTest {

    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        remoteControl.setCommand(0,
                new LightOnCommand(livingRoomLight),
                new LightOffCommand(livingRoomLight));

        remoteControl.setCommand(1,
                new LightOnCommand(kitchenLight),
                new LightOffCommand(kitchenLight));

        remoteControl.setCommand(2,
                new CeilingFanOnCommand(ceilingFan),
                new CeilingFanOffCommand(ceilingFan));

        remoteControl.setCommand(3,
                new StereoOnWithCDCommand(stereo),
                new StereoOffCommand(stereo));

        System.out.println(remoteControl);

        for (int slot = 0; slot <= 3; slot++) {
            remoteControl.onButtonWasPushed(slot);
            remoteControl.offButtonWasPushed(slot);
        }

    }

}
