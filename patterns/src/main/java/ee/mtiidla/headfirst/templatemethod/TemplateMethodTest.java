package ee.mtiidla.headfirst.templatemethod;

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
