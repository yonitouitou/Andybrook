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
}
