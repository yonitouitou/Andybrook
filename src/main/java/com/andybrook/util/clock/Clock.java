package com.andybrook.util.clock;

public final class Clock {

    private static final IClock JAVA_CLOCK = new JavaClock();

    private Clock() {}

    /**
     * Gets the current time in milliseconds
     * @return
     */
    public static long millis() {
        return JAVA_CLOCK.millis();
    }

    /**
     * Gets the current time in nanoseconds
     * @return
     */
    public static long nanos() {
        return JAVA_CLOCK.nanos();
    }
}
