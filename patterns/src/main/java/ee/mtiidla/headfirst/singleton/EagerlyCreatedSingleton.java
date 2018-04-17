package ee.mtiidla.headfirst.singleton;

class EagerlyCreatedSingleton {

    private static final EagerlyCreatedSingleton instance = new EagerlyCreatedSingleton();

    private EagerlyCreatedSingleton() {
    }

    public static EagerlyCreatedSingleton getInstance() {
        return instance;
    }
}
