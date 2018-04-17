package ee.mtiidla.headfirst.singleton;

/**
 * When the singleton class is loaded, SingletonHelper class is not loaded into memory and only when
 * someone calls the getInstance method, this class gets loaded and creates the Singleton class
 * instance.
 *
 * This is the most widely used approach for Singleton class as it doesn’t require synchronization.
 * I am using this approach in many of my projects and it’s easy to understand and implement also.
 */
class InnerHelperSingleton {

    private InnerHelperSingleton() {
    }

    private static class SingletonHelper {
        private static final InnerHelperSingleton INSTANCE = new InnerHelperSingleton();
    }

    public static InnerHelperSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
