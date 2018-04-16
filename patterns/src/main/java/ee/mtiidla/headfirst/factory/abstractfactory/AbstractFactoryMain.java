package ee.mtiidla.headfirst.factory.abstractfactory;

/**
 * The Abstract Factory Pattern provides an interface for creating families of related or dependent
 * objects without specifying their concrete classes.
 */
class AbstractFactoryMain {

    public static void main(String[] args) {

        PizzaStore nyStore = new NYPizzaStore();
        nyStore.orderPizza("cheese");

        PizzaStore chicagoStore = new ChicagoPizzaStore();
        chicagoStore.orderPizza("clam");

    }

}
