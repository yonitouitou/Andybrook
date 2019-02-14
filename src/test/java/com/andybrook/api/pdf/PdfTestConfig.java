package com.andybrook.api.pdf;

import com.andybrook.ApplicationProperties;
import com.andybrook.language.LanguageResolver;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class PdfTestConfig {

    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:language/messages");
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setCacheSeconds(3);
        return messageSource;
    }

    @Bean
    LanguageResolver languageResolver() {
        return new LanguageResolver();
    }

    @Bean
    ApplicationProperties applicationProperties() {
        ApplicationProperties appProperties = Mockito.mock(ApplicationProperties.class);
        Mockito.when(appProperties.getLocale()).thenReturn(new Locale("fr", "FR"));
        return appProperties;
    }

    @Bean
    CloseReportPdfBuilder closeReportPdfBuilder() {
        return new CloseReportPdfBuilder();
    }
}
