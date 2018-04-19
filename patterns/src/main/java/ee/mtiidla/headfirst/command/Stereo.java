package ee.mtiidla.headfirst.command;

class Stereo {

    void on() {
        System.out.println("Stereo turned on");
    }

    void off() {
        System.out.println("Stereo turned off");
    }

    void setCD() {
        System.out.println("Stereo playing CD");
    }

    void setDVD() {
        System.out.println("Stereo playing DVD");
    }

    void setRadio() {
        System.out.println("Stereo playing radio");
    }

    void setVolume(int volume) {
        System.out.println("Stereo volume set to " + volume);
    }

}
