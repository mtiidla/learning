package ee.mtiidla.headfirst.command;

class Light {

    private final String location;

    Light(String location) {
        this.location = location;
    }

    void on() {
        System.out.println(location + " light turned on");
    }

    void off() {
        System.out.println(location + " light turned off");
    }

}
