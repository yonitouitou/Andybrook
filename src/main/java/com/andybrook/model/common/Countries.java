package com.andybrook.model.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class Countries {

    private static final List<String> COUNTRIES;

    static {
        String[] locales = Locale.getISOCountries();
        List<String> l = new LinkedList<>();
        int i = 0;
        for (String countryCode : locales) {
            Locale locale = new Locale("", countryCode);
            l.add(locale.getDisplayCountry());
        }
        COUNTRIES = Collections.unmodifiableList(l);
    }


    public static List<String> get() {
        return COUNTRIES;
    }

}
