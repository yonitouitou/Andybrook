package com.andybrook.util;

import com.andybrook.util.clock.Clock;

import java.util.UUID;

public class IdGenerator {

    public static long generateId() {
        return Clock.nanos();
    }

    public static String generateAlfaNumericId() {
        return UUID.randomUUID().toString();
    }
}
