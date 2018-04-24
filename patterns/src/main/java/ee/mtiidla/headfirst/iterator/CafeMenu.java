package ee.mtiidla.headfirst.iterator;

import java.util.HashMap;
import java.util.Iterator;

class CafeMenu implements Menu {

    private final HashMap<String, MenuItem> menuItems;

    CafeMenu() {
        menuItems = new HashMap<>();

        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato and fries",
                true,
                3.99);
        addItem("Soup of the day",
                "A cup of soup of the day, with a side salad",
                false,
                3.69);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true,
                4.29);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.put(name, new MenuItem(name, description, vegetarian, price));
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return menuItems.values().iterator();
    }
}
