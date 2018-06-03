package ee.mtiidla.headfirst.mediator;

/**
 * The Mediator Pattern can be used to centralize complex communications and control between related
 * objects.
 *
 * Without Mediator Pattern, all of the Colleagues would know about each other, leading to high
 * coupling. By having all colleagues communicate through one central point we have a decoupled
 * system while maintaining control on the object's interactions.
 *
 */
class ChatMediatorMain {

    public static void main(String[] args) {
        ApplicationMediator mediator = new ApplicationMediator();
        Colleague desktop = new DesktopColleague(mediator);
        Colleague mobile = new MobileColleague(mediator);
        mediator.addColleague(desktop);
        mediator.addColleague(mobile);
        desktop.send("Hello World");
        mobile.send("Hello");
    }
}
