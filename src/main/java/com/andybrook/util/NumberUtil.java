package com.andybrook.util;

import org.springframework.util.NumberUtils;

public final class NumberUtil {

    public static <T extends Number> T parseNumber(String value, Class<T> clazz) {
        T number;
        try {
            number = NumberUtils.parseNumber(value, clazz);
        } catch (NumberFormatException e) {
            number = null;
        }
        return number;
    }
}
