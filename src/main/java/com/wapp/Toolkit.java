package com.wapp;

public class Toolkit implements StationToolkit {
    private static AlarmClockImp itsClockImp = new TestAlarmClockImpl();
    @Override
    public TemperatureSensorImp makeTemperature() {
        return new TestTemperatureImp();
    }
    @Override
    public AlarmClockImp getAlarmClock() {
        return itsClockImp;
    }
}
