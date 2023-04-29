package weatherMonitoringSystem;

import api.BarometricPressureSensorImp;
import api.StationToolkit;

import java.util.Observable;

public class BarometricPressureSensor extends Observable {
    private BarometricPressureSensorImp itsImp;
    private double itsLastReading;

    private void check() {
        double newPressure = read();
        if (newPressure != itsLastReading) {
            itsLastReading = newPressure;
            setChanged();
            notifyObservers(itsLastReading);
        }
    }
    public BarometricPressureSensor(AlarmClock ac, StationToolkit st) {
        itsImp = st.makeBarometricPressure();
        AlarmClockListener listener = new AlarmClockListener() {
            @Override
            public void wakeUp() {
                check();
            }
        };
        ac.wakeEvery(5000, listener);
    }
    public double read() {
        return itsImp.read();
    }

}
