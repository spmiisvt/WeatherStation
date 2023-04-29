package weatherMonitoringSystem;

import api.AlarmClockImp;
import api.ClockListener;
import api.StationToolkit;

import java.util.Hashtable;

public class AlarmClock {
    private AlarmClockImp itsAlarmClockImp;
    private Hashtable<AlarmClockListener, Long> itsListener;

    private void wake() {
        for (AlarmClockListener al : itsListener.keySet()) {
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
    public void wakeEvery(long interval, AlarmClockListener al) {
        itsListener.put(al, interval);
    }
}