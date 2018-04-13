package ee.mtiidla.headfirst.decorator;

abstract class Beverage {

    String description = "Unknown beverage";
    private Size size;

    public abstract double cost();

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
