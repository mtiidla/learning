package ee.mtiidla.headfirst.factory.abstractfactory;

import java.util.List;

interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    List<Veggie> createVeggies();

    Pepperoni createPepperoni();

    Clams createClams();

}
