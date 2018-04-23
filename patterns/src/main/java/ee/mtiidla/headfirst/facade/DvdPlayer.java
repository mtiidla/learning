package ee.mtiidla.headfirst.facade;

class DvdPlayer {

    void on() {
        System.out.println("DVD player on");
    }

    void off() {
        System.out.println("DVD player off");
    }

    void eject() {
        System.out.println("DVD player eject");
    }

    void play(String movie) {
        System.out.println("DVD player playing: " + movie);
    }

    void stop() {
        System.out.println("DVD player stopped playing movie");
    }
}
