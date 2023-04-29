package test;

import api.BarometricPressureSensorImp;

public class TestBarometricPressure implements BarometricPressureSensorImp {
    @Override
    public double read() {
        return 1.0;
    }
}
