package ee.mtiidla.headfirst.composite;

/**
 * The Composite Pattern allows you to compose objects into tree structures to represent part-whole
 * hierarchies. Composite lets clients treat individual objects and compositions of objects
 * uniformly.
 */
class CompositeMenuTest {

    public static void main(String[] args) {

        MenuComponent pancakeHouseMenu = createPancakeMenu();
        MenuComponent dinerMenu = createDinerMenu();
        MenuComponent cafeMenu = createCafeMenu();
        MenuComponent dessertMenu = createDessertMenu();

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(dessertMenu);

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();

        waitress.printVegetarianMenu();
    }

    private static MenuComponent createPancakeMenu() {
        MenuComponent menu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        addItem(menu, "K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99);
        addItem(menu, "Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);
        addItem(menu, "Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);
        addItem(menu, "Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
        return menu;
    }

    private static MenuComponent createCafeMenu() {
        MenuComponent menu = new Menu("CAFE MENU", "Dinner");
        addItem(menu, "Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato and fries",
                true,
                3.99);
        addItem(menu, "Soup of the day",
                "A cup of soup of the day, with a side salad",
                false,
                3.69);
        addItem(menu, "Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true,
                4.29);
        return menu;
    }

    private static MenuComponent createDessertMenu() {
        MenuComponent menu = new Menu("DESSERT MENU", "Dessert of course!");
        addItem(menu, "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla ice-cream",
                true,
                1.59);
        return menu;
    }

    private static MenuComponent createDinerMenu() {
        MenuComponent menu = new Menu("DINER MENU", "Lunch");
        addItem(menu, "Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);
        addItem(menu, "BLT",
                "Bacon with lettuce € tomato on whole wheat",
                false,
                2.99);
        addItem(menu, "Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.29);
        addItem(menu, "Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05);
        return menu;
    }

    private static void addItem(MenuComponent menu, String name, String description,
            boolean vegetarian, double price) {
        menu.add(new MenuItem(name, description, vegetarian, price));
    }

}
