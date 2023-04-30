package persistence;

import wmsdata.HiLoData;
import wmsdata.NoSuchDateException;

import java.util.Date;

public class DataToolkit implements wmsdata.DataToolkit {

    final private String tempKey = "Temp";
    @Override
    public HiLoData getTempHiLoData(Date aDate) throws NoSuchDateException {
        return new HiLoDataProxy(tempKey, aDate);
    }

    @Override
    public HiLoData getTempHiLoData(Date aDate, double initialValue) {
        return new HiLoDataProxy(tempKey, aDate, initialValue);
    }
}
