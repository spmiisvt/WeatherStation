package wmsdata;

public class NoSuchDateException extends Exception {
    public NoSuchDateException(String key)
    {
        super(key + " object not found");
    }
}
