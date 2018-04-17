package ee.mtiidla.headfirst.singleton;

/**
 * Singleton - Ensure a class only has one instance and provide a global point of access to it.
 */
class SingleThreadSingleton {

    private static SingleThreadSingleton instance;

    private SingleThreadSingleton() {
    }

    public static SingleThreadSingleton getInstance() {
        if (instance == null) {
            instance = new SingleThreadSingleton();
        }
        return instance;
    }
}
