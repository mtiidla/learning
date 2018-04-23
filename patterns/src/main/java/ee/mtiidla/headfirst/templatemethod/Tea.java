package ee.mtiidla.headfirst.templatemethod;

class Tea extends CaffeineBeverage {
    @Override
    protected void addCondiments() {
        System.out.println("Adding lemo");
    }

    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }
}
