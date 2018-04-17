package ee.mtiidla.headfirst.singleton;

/**
 * Does not work in Java 1.4 or earlier.
 *
 * Note that when using multiple classloaders, you can load the same class multiple times (once in
 * each classloader). To avoid this problem, specify the classloader yourself.
 */
class DoubleCheckedLockingSingleton {

    /**
     * The volatile keyword ensures that multiple thread handle the instance variable correctly when
     * it is being initialized to the Singleton instance.
     *
     * The real problem is that Thread A may assign a memory space for instance before it is
     * finished constructing instance. Thread B will see that assignment and try to use it. This
     * results in Thread B failing because it is using a partially constructed version of instance.
     */
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public synchronized DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
