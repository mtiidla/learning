package ee.mtiidla.headfirst.observer.pull;

class WeatherStationPull {

    public static void main(String[] args) {

        WeatherDataObservable weatherData = new WeatherDataObservable();

        new CurrentConditionsDisplayObserver(weatherData);
        new StatisticsDisplayObserver(weatherData);
        new ForecastDisplayObserver(weatherData);
        new HeatIndexDisplayObserver(weatherData);

        weatherData.setMeasurements(10, 65, 30.4f);
        weatherData.setMeasurements(15, 70, 31.4f);
        weatherData.setMeasurements(20, 90, 30.6f);
    }

}
