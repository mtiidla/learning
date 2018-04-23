package ee.mtiidla.headfirst.facade;

class Amplifier {

    void on() {
        System.out.println("Amplifier on");
    }

    void off() {
        System.out.println("Amplifier off");
    }

    void setDvd(DvdPlayer dvd) {
        System.out.println("Amplifier setting dvd player to " + dvd);
    }

    void setSurroundSound() {
        System.out.println("Amplifier surround sound on");
    }

    void setVolume(int volume) {
        System.out.println(String.format("Amplifier setting volume to %d", volume));
    }

}
