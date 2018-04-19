package ee.mtiidla.headfirst.command;

class RemoteControlMacroTest {

    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light("Living Room");
        Stereo stereo = new Stereo();
        TV tv = new TV();
        Hottub hottub = new Hottub();

        Command[] partyOn = {
                new LightOnCommand(light),
                new StereoOnWithCDCommand(stereo),
                new TVOnCommand(tv),
                new HottubOnCommand(hottub)
        };

        Command[] partyOff = {
                new LightOffCommand(light),
                new StereoOffCommand(stereo),
                new TVOffCommand(tv),
                new HottubOffCommand(hottub)
        };

        remoteControl.setCommand(0,
                new MacroCommand(partyOn),
                new MacroCommand(partyOff));

        System.out.println(remoteControl);
        System.out.println("\n--- Pushing macro on ---\n");
        remoteControl.onButtonWasPushed(0);
        System.out.println("\n--- Pushing macro off ---\n");
        remoteControl.offButtonWasPushed(0);
    }

}
