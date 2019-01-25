package com.andybrook.util;

import com.andybrook.util.clock.Clock;

public class IdGenerator {

    public static long generateId() {
        return Clock.nanos();
    }
}
