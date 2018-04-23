package ee.mtiidla.headfirst.facade;

/**
 * The Facade Pattern provides a unified interface to a set of interfaces in a subsystem. Facade
 * defines a higher-level interface that makes the subsystem easier to user.
 */
class HomeTheaterTest {

    public static void main(String[] args) {

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                new Amplifier(), new DvdPlayer(), new Projector(), new TheaterLights(),
                new Screen(), new PopcornPopper()
        );

        homeTheater.watchMovie("Raiders of the lost ark");
        System.out.println("\n");
        homeTheater.endMovie();

    }

}
