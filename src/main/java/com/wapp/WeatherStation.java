package com.wapp;

import java.util.Observable;
import java.util.Observer;

public class WeatherStation {
    public static void main(String[] args) {
        StationToolkit st = new Toolkit();
        AlarmClock ac = new AlarmClock(st);

        TemperatureSensor ts = new TemperatureSensor(ac, st);

        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                Double d = (Double) arg;
                temperatureChanged(d);
            }
        };
        ts.addObserver(observer);
        for(;;) {}
    }
    private static void temperatureChanged(double value) {
        System.out.println("Temp was changed: " + value);
    }
}