package weatherMonitoringSystem;
import api.StationToolkit;
import api.TemperatureSensorImp;

import java.util.Observable;
import java.lang.Double;


public class TemperatureSensor extends Observable {
    private TemperatureSensorImp itsImp;
    private double itsLastReading = Double.NaN;
    private void check() {
        System.out.println("In check");
        double newReadTemp = read();
        if (newReadTemp != itsLastReading)
        {
            itsLastReading = newReadTemp;
            setChanged();
            notifyObservers(itsLastReading);
        }
    }
   public TemperatureSensor(AlarmClock ac, StationToolkit st) {
        itsImp = st.makeTemperature();

        AlarmClockListener observer = new AlarmClockListener() {
            public void wakeUp() {
                check();
            }
        };

        ac.wakeEvery(1000, observer);
   }
   public double read() {
        return itsImp.read();
   }

}
