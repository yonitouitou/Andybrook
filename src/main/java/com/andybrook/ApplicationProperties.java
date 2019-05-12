package com.andybrook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.util.Locale;

@Configuration
public class ApplicationProperties {

    private Locale locale;
    private ZoneId zoneId;

    @Value("${language.locale.code:en}")
    private String localeCode;
    @Value("${language.locale.code:US}")
    private String localeCountry;
    @Value("${zone.id:America/New_York}")
    private String zoneIdName;
    @Value("${notification.email.from}")
    private String notificationEmailFrom;

    public String getNotificationEmailFrom() {
        return notificationEmailFrom;
    }

    public Locale getLocale() {
        if (locale == null) {
            locale = new Locale(localeCode, localeCountry);
        }
        return locale;
    }

    public ZoneId getZoneId() {
        if (zoneId == null) {
            zoneId = ZoneId.of(zoneIdName);
        }
        return zoneId;
    }
}
