package ee.mtiidla.headfirst.templatemethod;

/**
 * The Template Method Pattern defines the skeleton of an algorithm in a method, deferring some
 * steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm
 * without changing the algorithm's structure.
 */
class TemplateMethodTest {

    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        System.out.println("Preparing tea...");
        tea.prepareRecipe();

        CaffeineBeverage coffee = new Coffee();
        System.out.println("\nPreparing coffee...");
        coffee.prepareRecipe();

        CaffeineBeverage coffeeWithHook = new CoffeeWithHook();
        System.out.println("\nPreparing coffee with hook...");
        coffeeWithHook.prepareRecipe();

    }

}
