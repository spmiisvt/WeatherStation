package weatherMonitoringSystem;

import api.StationToolkit;

import java.util.Observer;

public class WeatherStation {
   private TemperatureSensor itsTS;
   private BarometricPressureSensor itsBPS;

   public WeatherStation(String tkName) throws Exception {
       Class<?> Klass = Class.forName(tkName);
       StationToolkit tk = (StationToolkit) Klass.newInstance();
       AlarmClock ac = new AlarmClock(tk);
       itsTS = new TemperatureSensor(ac, tk);
       itsBPS = new BarometricPressureSensor(ac, tk);

   }
   public void addTempObserver(Observer o) {
       itsTS.addObserver(o);
   }
   public void addBPObserver(Observer o) {
       itsBPS.addObserver(o);
   }
}