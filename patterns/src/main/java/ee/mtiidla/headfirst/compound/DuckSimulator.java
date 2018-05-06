package ee.mtiidla.headfirst.compound;

class DuckSimulator {

    public static void main(String[] args) {

        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate(new CountingDuckFactory(), new GooseFactory());

    }

    void simulate(AbstractDuckFactory duckFactory, AbstractGooseFactory gooseFactory) {

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(duckFactory.createRedHeadDuck());
        flockOfDucks.add(duckFactory.createDuckCall());
        flockOfDucks.add(duckFactory.createRubberDuck());
        flockOfDucks.add(gooseFactory.createGoose());

        Flock flockOfMallards = new Flock();
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());

        flockOfDucks.add(flockOfMallards);

        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        System.out.println("\nDuck Simulator: Whole Flock Simulator");
        simulate(flockOfDucks);

        System.out.println("\nThe ducks quacked: "+ +QuackCounter.getNumberOfQuacks() + " times");
    }

    void simulate(Quackable quackable) {
        quackable.quack();
    }

}
