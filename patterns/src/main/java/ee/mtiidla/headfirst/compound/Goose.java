package ee.mtiidla.headfirst.compound;

class Goose {

    void honk() {
        System.out.println("Honk");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
