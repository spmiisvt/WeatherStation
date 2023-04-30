package persistence;

import api.PersistentImp;
import api.RetrieveException;
import api.StoreException;
import wmsdata.HiLoData;
import wmsdataimp.HiLoDataImp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HiLoDataProxy implements HiLoData {

    public HiLoDataProxy(String type, Date aDate)
            throws wmsdata.NoSuchDateException
    {
        itsType = type;
        itsStorageKey = calculateStorageKey(new Date());

        itsPI = api.Scope.stationToolkit.getPersistentImp();

        try
        {
            itsHiLoData = (HiLoDataImp)itsPI.retrieveObject(itsStorageKey);
        }
        catch(RetrieveException re)
        {
            throw new wmsdata.NoSuchDateException(itsStorageKey);
        }
    }
    public HiLoDataProxy(String type,
                     Date aDate,
                     double initialValue)
    {
        itsType = type;
        itsStorageKey = calculateStorageKey(aDate);

        itsPI = api.Scope.stationToolkit.getPersistentImp();

        try
        {
            itsHiLoData = (HiLoDataImp)itsPI.retrieveObject(itsStorageKey);
            itsHiLoData.currentReading(initialValue, aDate.getTime());
        }
        catch(RetrieveException re)
        {
            itsHiLoData = new HiLoDataImp(initialValue, aDate.getTime());
            store();
        }
    }

    @Override
    public boolean currentReading(double value, long time)
    {
        if(itsHiLoData.currentReading(value, time))
        {
            store();
            return true;
        }
        return false;
    }

    @Override
    public void newDay(double initialValue, long time)
    {
        store();
        itsHiLoData.newDay(initialValue, time);
        itsStorageKey = calculateStorageKey(new Date(time));
        store();
    }

    @Override
    public double getHighValue() {
        return 0;
    }

    @Override
    public double getLowValue() {
        return 0;
    }

    @Override
    public long getHighTime() {
        return 0;
    }

    @Override
    public long getLowTime() {
        return 0;
    }
    private void store()
    {
        try
        {
            itsPI.store(itsStorageKey, itsHiLoData);
        }
        catch(StoreException se)
        {
            System.out.println("Error:::: " + se);
        }
    }
    private String calculateStorageKey(Date theDate)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        return (itsType + "HiLo" + dateFormat.format(theDate));
    }
    private HiLoDataImp itsHiLoData;
    private PersistentImp itsPI;
    private String itsType;
    private String itsStorageKey;
}
