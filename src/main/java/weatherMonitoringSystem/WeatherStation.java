package weatherMonitoringSystem;

import api.Scope;
import api.StationToolkit;
import test.TestToolkit;
import wsComponent.WeatherStationComponent;

import java.util.Observer;

public class WeatherStation implements WeatherStationComponent {
   private TemperatureSensor itsTS;
   private BarometricPressureSensor itsBPS;
   private TempHiLo itsTempHiLo;

   public WeatherStation() {

       StationToolkit stk = new TestToolkit();
       Scope.stationToolkit = stk;
       AlarmClock ac = new AlarmClock(stk);
       itsTS = new TemperatureSensor(ac, stk);
       itsBPS = new BarometricPressureSensor(ac, stk);
       itsTempHiLo = new TempHiLo(ac, itsTS);

   }
   public void addTempObserver(Observer o) {
       itsTS.addObserver(o);
   }
   public void addBPObserver(Observer o) {
       itsBPS.addObserver(o);
   }
}