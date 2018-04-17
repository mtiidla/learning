package ee.mtiidla.headfirst.singleton;

class SlowMultiThreadSingleton {

    private static SlowMultiThreadSingleton instance;

    private SlowMultiThreadSingleton() {
    }

    public static synchronized SlowMultiThreadSingleton getInstance() {
        if (instance == null) {
            instance = new SlowMultiThreadSingleton();
        }
        return instance;
    }
}
