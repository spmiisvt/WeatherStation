package test;


import api.AlarmClockImp;
import api.ClockListener;

public class TestAlarmClock implements AlarmClockImp {
    @Override
    public void register(ClockListener listener) {
        new Timer(1000, listener).start();
    }
}
