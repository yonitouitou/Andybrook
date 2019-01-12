package com.andybrook.util.clock;

public interface IClock {

    /**
     * Get the current time in millisecond
     * @return
     */
    long millis();

    /**
     * Get the current time in nanosecond
     * @return
     */
    long nanos();
}
