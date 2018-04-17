package ee.mtiidla.headfirst.singleton;

enum EnumSingleton {

    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
