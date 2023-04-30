package test;

import api.BarometricPressureSensorImp;

import java.util.Random;

public class TestBarometricPressure implements BarometricPressureSensorImp {
    private static final Random random = new Random();
    @Override
    public double read() {
        return Math.round(random.nextDouble((50-47) + 1) + 47);
    }
}
