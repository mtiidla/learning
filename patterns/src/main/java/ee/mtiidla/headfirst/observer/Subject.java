package ee.mtiidla.headfirst.observer;

interface Subject {

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();

}
