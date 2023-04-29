package test;

import api.AlarmClockImp;
import api.BarometricPressureSensorImp;
import api.StationToolkit;
import api.TemperatureSensorImp;

public class TestToolkit implements StationToolkit {
    private static AlarmClockImp itsClockImp = new TestAlarmClock();

    @Override
    public BarometricPressureSensorImp makeBarometricPressure() {
        return new TestBarometricPressure();
    }

    @Override
    public TemperatureSensorImp makeTemperature() {
        return new TestTemperature();
    }
    @Override
    public AlarmClockImp getAlarmClock() {
        return itsClockImp;
    }
}
