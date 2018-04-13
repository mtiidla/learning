package ee.mtiidla.headfirst.decorator;

/**
 * Decorator - Attach additional responsibilities to an object dynamically. Decorators provide a
 * flexible alternative to subclassing for extending functionality.
 */
class StarBuzzCoffee {

    public static void main(String[] args) {

        Beverage beverage = new Espresso();
        printBeverage(beverage);

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        printBeverage(beverage1);

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        beverage2.setSize(Size.LARGE);
        printBeverage(beverage2);
    }

    private static void printBeverage(Beverage beverage) {
        System.out.println(String.format("%s: %.2f€", beverage.getDescription(), beverage.cost()));
    }

}
