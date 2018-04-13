package ee.mtiidla.headfirst.observer.pull;

import java.util.Observable;
import java.util.Observer;

import ee.mtiidla.headfirst.observer.WeatherDisplay;

class StatisticsDisplayObserver implements WeatherDisplay, Observer {

    private float avgTemperature;
    private float avgHumidity;
    private float avgPressure;
    private int readings;
    private final Observable weatherData;

    public StatisticsDisplayObserver(Observable weatherData) {
        this.weatherData = weatherData;
        this.weatherData.addObserver(this);
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

    @Override
    public void update(Observable o, Object arg) {
        WeatherDataObservable weather = (WeatherDataObservable) o;
        avgTemperature = getAverage(weather.getTemperature(), avgTemperature);
        avgHumidity = getAverage(weather.getHumidity(), avgHumidity);
        avgPressure = getAverage(weather.getPressure(), avgPressure);
        readings++;
        display();
    }
}
