package ee.mtiidla.headfirst.factory.method;

import ee.mtiidla.headfirst.factory.NYStyleCheesePizza;
import ee.mtiidla.headfirst.factory.NYStyleClamPizza;
import ee.mtiidla.headfirst.factory.NYStylePepperoniPizza;
import ee.mtiidla.headfirst.factory.NYStyleVeggiePizza;
import ee.mtiidla.headfirst.factory.Pizza;

class NYStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        } else if (type.equals("clam")) {
            return new NYStyleClamPizza();
        } else if (type.equals("veggie")) {
            return new NYStyleVeggiePizza();
        }
        return pizza;
    }
}
