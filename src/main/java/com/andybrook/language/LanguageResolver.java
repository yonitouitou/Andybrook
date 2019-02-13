package com.andybrook.language;

import com.andybrook.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class LanguageResolver {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ApplicationProperties applicationProperties;

    public String get(String code) {
        return messageSource.getMessage(code, null, applicationProperties.getLocale());
    }
}
