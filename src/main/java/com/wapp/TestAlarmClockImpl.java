package com.wapp;


public class TestAlarmClockImpl implements AlarmClockImp {
    @Override
    public void register(ClockListener listener) {
        new Timer(1000, listener).start();
    }
}
