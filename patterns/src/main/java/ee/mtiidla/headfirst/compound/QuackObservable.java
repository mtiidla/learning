package ee.mtiidla.headfirst.compound;

interface QuackObservable {

    void registerObserver(Observer observer);

    void notifyObservers();

}
