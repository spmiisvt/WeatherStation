package wmsdata;

public interface HiLoData {
    boolean currentReading(double current, long time);
    void newDay(double initial, long time);
    double getHighValue();
    double getLowValue();
    long getHighTime();
    long getLowTime();
}
