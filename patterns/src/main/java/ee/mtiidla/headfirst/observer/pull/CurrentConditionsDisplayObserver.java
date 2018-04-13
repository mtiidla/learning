package ee.mtiidla.headfirst.observer.pull;

import java.util.Observable;
import java.util.Observer;

import ee.mtiidla.headfirst.observer.WeatherDisplay;

class CurrentConditionsDisplayObserver implements Observer, WeatherDisplay {

    private float temperature;
    private float humidity;

    private final Observable weatherData;

    public CurrentConditionsDisplayObserver(Observable weatherData) {
        this.weatherData = weatherData;
        this.weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("Current weather: %.1fC degrees, %.1f%% humidity", temperature,
                humidity));
    }

    @Override
    public void update(Observable o, Object arg) {
        WeatherDataObservable weather = (WeatherDataObservable) o;
        this.temperature = weather.getTemperature();
        this.humidity = weather.getHumidity();
        display();
    }
}
