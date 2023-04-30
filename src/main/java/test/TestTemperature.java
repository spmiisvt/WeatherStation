package test;

import api.TemperatureSensorImp;

import java.util.Random;

public class TestTemperature implements TemperatureSensorImp {
    private static final Random random = new Random();

    @Override
    public double read() {
        return Math.round(random.nextDouble((20-17) + 1) + 17);
    }
}
