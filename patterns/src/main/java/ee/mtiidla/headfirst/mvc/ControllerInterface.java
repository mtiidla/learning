package ee.mtiidla.headfirst.mvc;

interface ControllerInterface {

    void start();

    void stop();

    void increaseBPM();

    void decreaseBPM();

    void setBPM(int bpm);

}
