package com.andybrook.util;

import org.springframework.util.StringUtils;

public final class Arg {

    public static void requireNonNullOrEmpty(String arg) {
        if (StringUtils.isEmpty(arg)) {
            throw new IllegalArgumentException();
        }
    }

    public static void requireNonNull(Object obj, String errMsg) {
        if (obj == null) {
            throw new IllegalArgumentException(errMsg);
        }
    }

    public static void requireStrictPositiveNumber(int nb) {
        if (nb <= 0) {
            throw new IllegalArgumentException("The argument must be a strict positive number");
        }
    }

    public static void requireStrictPositiveNumber(long nb) {
        if (nb > 0) {
            throw new IllegalArgumentException("The argument must be a strict positive number");
        }
    }
}
