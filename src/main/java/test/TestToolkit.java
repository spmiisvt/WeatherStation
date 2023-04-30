package test;

import api.*;

public class TestToolkit implements StationToolkit {
    private static AlarmClockImp itsClockImp = new TestAlarmClock();
    private static PersistentImp itsPersistentImp = new TestPersistentImp();

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

    @Override
    public PersistentImp getPersistentImp() {
        return itsPersistentImp;
    }
}
