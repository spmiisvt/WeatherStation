package com.wapp;

import java.util.Hashtable;

public class AlarmClock {
    private AlarmClockImp itsAlarmClockImp;
    private Hashtable<AlarmListener, Long> itsListener;

    private void wake() {
        for (AlarmListener al : itsListener.keySet()) {
            al.wakeUp();
        }
    }
    public AlarmClock(StationToolkit st)
    {
        itsAlarmClockImp = (AlarmClockImp) st.getAlarmClock();
        ClockListener cl = new ClockListener() {
            @Override
            public void tic() {
                wake();
            }
        };
        itsAlarmClockImp.register(cl);
        itsListener = new Hashtable<>();
    }
    public void wakeEvery(long interval, AlarmListener al) {
        itsListener.put(al, interval);
    }
}
