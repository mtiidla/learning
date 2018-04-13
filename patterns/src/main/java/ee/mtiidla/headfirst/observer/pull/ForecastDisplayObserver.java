package ee.mtiidla.headfirst.observer.pull;

import java.util.Observable;
import java.util.Observer;

import ee.mtiidla.headfirst.observer.WeatherDisplay;

class ForecastDisplayObserver implements Observer, WeatherDisplay {

    private final Observable weatherData;

    ForecastDisplayObserver(Observable weatherData) {
        this.weatherData = weatherData;
        this.weatherData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        display();
    }

    @Override
    public void display() {
        System.out.println("Forecast is unexpected!");
    }
}
