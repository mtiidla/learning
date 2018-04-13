package ee.mtiidla.headfirst.observer;

/**
 * Observer - defines a one-to-many dependency between objects so that when one object changes
 * state, all its dependents are notified and updated automatically
 */
class WeatherStation {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        new CurrentConditionsDisplay(weatherData);
        new StatisticsDisplay(weatherData);
        new ForecastDisplay(weatherData);
        new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(10, 65, 30.4f);
        weatherData.setMeasurements(15, 70, 31.4f);
        weatherData.setMeasurements(20, 90, 30.6f);
    }

}
