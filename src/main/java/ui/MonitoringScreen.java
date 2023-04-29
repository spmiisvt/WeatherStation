package ui;

import wsComponent.WeatherStationComponent;

import java.util.Observable;
import java.util.Observer;

public class MonitoringScreen {

    public MonitoringScreen(WeatherStationComponent wsc) {
        Observer tempObserver = new Observer() {

            @Override
            public void update(Observable o, Object arg) {
                Double t = (Double) arg;
                displayTemperature(t);
            }
        };
        wsc.addTempObserver(tempObserver);
        Observer pressureObserver = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                Double p = (Double) arg;
                displayPressure(p);
            }
        };
        wsc.addBPObserver(pressureObserver);
    }
    private void displayTemperature(double value) {
        System.out.println("Temperature: " + value);
    }
    private void displayPressure(double value) {
        System.out.println("Barometric pressure: " + value);
    }
}
