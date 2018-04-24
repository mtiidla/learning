package ee.mtiidla.headfirst.iterator;

import java.util.Iterator;

class DinerMenu implements Menu {

    private static final int MAX_ITEMS = 6;
    private final MenuItem[] menuItems;
    private int numberOfItems = 0;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);
        addItem("BLT",
                "Bacon with lettuce € tomato on whole wheat",
                false,
                2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.29);
        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("Sorry, menu is full!");
        } else {
            menuItems[numberOfItems++] = menuItem;
        }
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator(menuItems);
    }

}
