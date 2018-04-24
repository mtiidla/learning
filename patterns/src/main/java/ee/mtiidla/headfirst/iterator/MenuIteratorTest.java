package ee.mtiidla.headfirst.iterator;

/**
 * The Iterator Pattern provides a way to access the elements of an aggregate object sequentially
 * without exposing its underlying representation
 */
class MenuIteratorTest {

    public static void main(String[] args) {

        Waitress waitress = new Waitress(new PancakeHouseMenu(), new DinerMenu(), new CafeMenu());
        waitress.printMenu();
    }

}
