package test;

import api.PersistentImp;
import api.RetrieveException;
import api.StoreException;

import java.io.*;
import java.util.AbstractList;
import java.util.Vector;

class TestPersistentImp implements PersistentImp {
    @Override
    public void store(String name, Serializable object) throws StoreException {
        try
        {
            FileOutputStream f = new FileOutputStream(name);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(object);
        }
        catch(Exception e)
        {
            throw new StoreException();
        }
    }

    @Override
    public Object retrieveObject(String name) throws RetrieveException {
        System.out.println("Key : " + name);
        try
        {
            FileInputStream in = new FileInputStream(name);
            ObjectInputStream s = new ObjectInputStream(in);
            Object obj = (Object)s.readObject();
            return obj;
        }
        catch (Exception e)
        {
            throw new RetrieveException();
        }
    }

    @Override
    public AbstractList directory(String name)
    {
        return new Vector();
    }
}
