package ee.mtiidla.headfirst.command;

class SimpleRemoteControlTest {

    public static void main(String[] args) {

        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light("Kitchen");
        LightOnCommand lightOn = new LightOnCommand(light);

        remoteControl.setCommand(lightOn);
        remoteControl.buttonWasPressed();

        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(new GarageDoor());
        remoteControl.setCommand(garageDoorOpen);
        remoteControl.buttonWasPressed();

    }

}
