package ee.mtiidla.headfirst.facade;

class TheaterLights {

    void dim(int level) {
        System.out.println(String.format("Theater ceiling lights dimming to %d%%", level));
    }

    void on() {
        System.out.println("Theater ceiling lights on");
    }

}
