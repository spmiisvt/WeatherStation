package weatherMonitoringSystem;

import api.StationToolkit;
import test.TestToolkit;
import wsComponent.WeatherStationComponent;

import java.util.Observer;

public class WeatherStation implements WeatherStationComponent {
   private TemperatureSensor itsTS;
   private BarometricPressureSensor itsBPS;

   public WeatherStation() {

       StationToolkit tk = new TestToolkit();
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