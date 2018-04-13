package ee.mtiidla.headfirst.observer;

class CurrentConditionsDisplay implements WeatherDisplay, Observer {

    private float temperature;
    private float humidity;

    private final Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println(String.format("Current weather: %.1fC degrees, %.1f%% humidity", temperature,
                humidity));
    }
}
