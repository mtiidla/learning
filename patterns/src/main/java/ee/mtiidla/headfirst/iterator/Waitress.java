package ee.mtiidla.headfirst.iterator;

import java.util.Iterator;

class Waitress {

    private final Menu breakfastMenu;
    private final Menu lunchMenu;
    private final Menu dinnerMenu;

    public Waitress(Menu breakfastMenu, Menu lunchMenu, Menu dinnerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.lunchMenu = lunchMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu() {
        System.out.println("MENU\n-----\nBREAKFAST");
        printMenu(breakfastMenu.createIterator());
        System.out.println("\nLUNCH");
        printMenu(lunchMenu.createIterator());
        System.out.println("\nDINNER");
        printMenu(dinnerMenu.createIterator());
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}
