package wmsdataimp;

import wmsdata.HiLoData;

public class HiLoDataImp implements java.io.Serializable, HiLoData {
    public HiLoDataImp(double initial, long time)
    {
        itsHighValue = itsLowValue = initial;
        itsHighTime = itsLowTime = time;
    }
    @Override
    public boolean currentReading(double current, long time)
    {
        boolean changed = false;
        if (current > itsHighValue)
        {
            itsHighValue = current;
            itsHighTime = time;
            changed = true;
        }
        else if (current < itsLowValue)
        {
            itsLowValue = current;
            itsLowTime = time;
            changed = true;
        }
        return changed;
    }

    @Override
    public void newDay(double initial, long time)
    {
        itsHighTime = itsLowTime = time;
        itsHighValue = itsLowValue = initial;
    }

    @Override
    public double getHighValue() {
        return itsHighValue;
    }
    @Override
    public double getLowValue() {
        return itsLowValue;
    }
    @Override
    public long getHighTime() {
        return itsHighTime;
    }
    @Override
    public long getLowTime() {
        return itsLowTime;
    }
    private double itsLowValue;
    private long itsLowTime;
    private double itsHighValue;
    private long itsHighTime;
}
