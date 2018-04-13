package ee.mtiidla.headfirst.observer.pull;

import java.util.Observable;
import java.util.Observer;
import ee.mtiidla.headfirst.observer.WeatherDisplay;

class HeatIndexDisplayObserver implements WeatherDisplay, Observer {

    private float heatIndex;
    private Observable weatherData;

    public HeatIndexDisplayObserver(Observable weatherData) {
        this.weatherData = weatherData;
        this.weatherData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        WeatherDataObservable weather = (WeatherDataObservable) o;
        heatIndex = calculateHeatIndex(weather.getTemperature(), weather.getHumidity());
        display();
    }

    @Override
    public void display() {
        System.out.println(String.format("Heat index: %.1f", heatIndex));
    }

    private float calculateHeatIndex(float t, float rh) {
        return (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
    }
}
