package ee.mtiidla.headfirst.observer;

class ForecastDisplay implements WeatherDisplay, Observer {

    private final Subject weatherData;

    ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        display();
    }

    @Override
    public void display() {
        System.out.println("Forecast is unexpected!");
    }
}
