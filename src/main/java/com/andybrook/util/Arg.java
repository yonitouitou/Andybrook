package com.andybrook.util;

import org.springframework.util.StringUtils;

public final class Arg {

    public static final void requireNonNullOrEmpty(String arg) {
        if (StringUtils.isEmpty(arg)) {
            throw new IllegalArgumentException();
        }
    }
}
