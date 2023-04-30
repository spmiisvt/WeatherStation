package weatherMonitoringSystem;

import wmsdata.HiLoData;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class TempHiLo {
    private AlarmClock itsAlarmClock;
    private TemperatureSensor itsSensor;
    private HiLoData itsData;
    public TempHiLo(AlarmClock al, TemperatureSensor ts) {
        itsSensor = ts;
        itsAlarmClock = al;

        Date d = new Date();
        double sensorData = itsSensor.read();
        itsData = wmsdata.Scope.itsDataToolkit.getTempHiLoData(d, sensorData);
        AlarmClockListener acl = new AlarmClockListener()
        {
            public void wakeUp()
            {
                newDay();
            }
        };
        itsAlarmClock.wakeEveryDay(acl);
        Observer o = new Observer()
        {
            public void update(Observable ob, Object anObject)
            {
                Double val = (Double)anObject;
                itsData.currentReading(val.doubleValue(),
                        System.currentTimeMillis());
            }
        };
        itsSensor.addObserver(o);
    }
    private void newDay()
    {
        double val = itsSensor.read();
        long time = System.currentTimeMillis();
        itsData.newDay(val, time);
    }
}
