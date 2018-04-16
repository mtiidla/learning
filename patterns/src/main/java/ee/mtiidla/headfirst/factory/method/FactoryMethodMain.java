package ee.mtiidla.headfirst.factory.method;

import ee.mtiidla.headfirst.factory.Pizza;

/**
 * The Factory Method Pattern defines an interface for creating an object, but lets subclasses
 * decide which class to instantiate. Factory Method lets a class defer instantiation to
 * subclasses.
 */
class FactoryMethodMain {

    public static void main(String[] args) {

        PizzaStore nyStore = new NYStylePizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        PizzaStore chicagoStore = new ChicagoStylePizzaStore();
        Pizza pizza1 = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza1.getName() + "\n");
    }

}
