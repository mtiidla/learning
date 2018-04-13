package ee.mtiidla.headfirst.observer;

class StatisticsDisplay implements WeatherDisplay, Observer {

    private float avgTemperature;
    private float avgHumidity;
    private float avgPressure;
    private int readings;
    private final Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        avgTemperature = getAverage(temperature, avgTemperature);
        avgHumidity = getAverage(humidity, avgHumidity);
        avgPressure = getAverage(pressure, avgPressure);
        readings++;
        display();
    }

    private float getAverage(float newValue, float prevAverage) {
        return (prevAverage * readings + newValue) / (readings + 1);
    }

    @Override
    public void display() {
        System.out.println(
                String.format("Average conditions: %.1fC degrees, %.1f%% humidity, %.1f pressure",
                        avgTemperature, avgHumidity, avgPressure));
    }
}
