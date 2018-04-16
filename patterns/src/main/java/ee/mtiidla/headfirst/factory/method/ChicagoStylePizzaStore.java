package ee.mtiidla.headfirst.factory.method;

import ee.mtiidla.headfirst.factory.ChicagoStyleCheesePizza;
import ee.mtiidla.headfirst.factory.ChicagoStyleClamPizza;
import ee.mtiidla.headfirst.factory.ChicagoStylePepperoniPizza;
import ee.mtiidla.headfirst.factory.ChicagoStyleVeggiePizza;
import ee.mtiidla.headfirst.factory.Pizza;

class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } else if (type.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
