package com.wapp;

import java.util.Random;

public class TestTemperatureImp implements TemperatureSensorImp {
    private static final Random random = new Random();

    @Override
    public double read() {
        return random.nextDouble();
    }
}
