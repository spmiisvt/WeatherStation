package weatherMonitoringSystem;

import api.AlarmClockImp;
import api.ClockListener;
import api.StationToolkit;

import java.util.Hashtable;

public class AlarmClock {
    private AlarmClockImp itsAlarmClockImp;
    private Hashtable<AlarmClockListener, Long> itsListener;
    private long countTick = 0;
    private long maxTime = Long.MIN_VALUE;

    private void clock() {
        for (AlarmClockListener al : itsListener.keySet()) {
            long val = itsListener.get(al);
            System.out.println(countTick);
            if (countTick % val == 0) {
                al.wakeUp();
                if (val == maxTime) {
                    countTick = 0;
                }
            }
        }
    }
    public AlarmClock(StationToolkit st)
    {
        itsAlarmClockImp = (AlarmClockImp) st.getAlarmClock();
        ClockListener cl = new ClockListener() {
            @Override
            public void tic() {
                countTick += 10;
                clock();
            }
        };
        itsAlarmClockImp.register(cl);
        itsListener = new Hashtable<>();
    }
    public void wakeEvery(long interval, AlarmClockListener al) {
        itsListener.put(al, interval);
        maxTime = Math.max(interval, maxTime);
    }
}
