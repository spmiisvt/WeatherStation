package api;

public interface StationToolkit {
    BarometricPressureSensorImp makeBarometricPressure();
    TemperatureSensorImp makeTemperature();
    AlarmClockImp getAlarmClock();
    PersistentImp getPersistentImp();
}
