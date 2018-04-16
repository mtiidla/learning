package ee.mtiidla.headfirst.factory.abstractfactory;

class CheesePizza extends Pizza {

    private final PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + getName());
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();

        System.out.println("Adding dough: "+ dough.getClass().getSimpleName());
        System.out.println("Adding sauce: "+ sauce.getClass().getSimpleName());
        System.out.println("Adding cheese: "+ cheese.getClass().getSimpleName());
        System.out.println("Adding veggies: ");
        for (Veggie veggy : veggies) {
            System.out.println(veggy.getClass().getSimpleName());
        }

    }
}
