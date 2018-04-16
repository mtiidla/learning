package ee.mtiidla.headfirst.factory.abstractfactory;

import java.util.List;

public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    List<Veggie> veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes in 200");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name == null ? getClass().getSimpleName() : name;
    }
}
