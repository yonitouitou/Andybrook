package com.andybrook.util.clock;

public class JavaClock implements IClock {

    @Override
    public long millis() {
        return System.currentTimeMillis();
    }

    @Override
    public long nanos() {
        return System.nanoTime();
    }
}
