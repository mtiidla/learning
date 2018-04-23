package ee.mtiidla.headfirst.templatemethod;

class Coffee extends CaffeineBeverage {
    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }
}
