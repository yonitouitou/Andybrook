package com.andybrook.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class DateUtil {

    public static ZonedDateTime epochTimeInMillisToZdt(long epochTime, ZoneId zoneId) {
        Instant i = Instant.ofEpochMilli(epochTime);
        return ZonedDateTime.ofInstant(i, zoneId);
    }
}
