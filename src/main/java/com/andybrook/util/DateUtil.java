package com.andybrook.util;

import java.time.*;

public final class DateUtil {

    public static ZonedDateTime epochTimeInMillisToZdt(long epochTime, ZoneId zoneId) {
        Instant i = Instant.ofEpochMilli(epochTime);
        return ZonedDateTime.ofInstant(i, zoneId);
    }

    public static long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
