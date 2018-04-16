package ee.mtiidla.headfirst.factory;

/**
 * The Simple Factory isn't actually a Design Pattern; it's more of a programming idiom.
 */
class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("greek")) {
            pizza = new GreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            return new ClamPizza();
        } else if (type.equals("veggie")) {
            return new VeggiePizza();
        }
        return pizza;
    }

}
