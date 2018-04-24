package ee.mtiidla.headfirst.iterator;

import java.util.Iterator;

class DinerMenuIterator implements Iterator<MenuItem> {

    private final MenuItem[] menuItems;
    private int position;

    DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.length && menuItems[position] != null;
    }

    @Override
    public MenuItem next() {
        return menuItems[position++];
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("Can't remove item until next() is called");
        }
        if (menuItems[position - 1] != null) {
            for (int i = position - 1; i < menuItems.length - 1; i++) {
                menuItems[i] = menuItems[i + 1];
            }
            menuItems[menuItems.length - 1] = null;
        }
    }
}
