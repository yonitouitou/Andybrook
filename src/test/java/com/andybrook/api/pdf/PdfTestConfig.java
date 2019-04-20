package com.andybrook.api.pdf;

import com.andybrook.ApplicationProperties;
import com.andybrook.dao.jpa.repository.IAdminSettingRepository;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.setting.AdminSettingDao;
import com.andybrook.dao.setting.IAdminSettingDao;
import com.andybrook.language.LanguageResolver;
import com.andybrook.model.setting.AdminSetting;
import com.andybrook.service.setting.AdminSettingService;
import com.andybrook.service.setting.IAdminSettingService;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.awt.*;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

public class PdfTestConfig {

    private AdminSetting setting = new AdminSetting(1L, null, null, 10, Color.LIGHT_GRAY, Color.BLACK);

    @MockBean
    IAdminSettingRepository adminSettingRepository;

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
        Mockito.when(appProperties.getZoneId()).thenReturn(ZoneId.of("Europe/Paris"));
        return appProperties;
    }

    @Bean
    CloseReportPdfBuilder closeReportPdfBuilder() {
        return new CloseReportPdfBuilder();
    }

    @Bean
    IAdminSettingService adminSettingService() {
        AdminSettingService adminSettingService = Mockito.mock(AdminSettingService.class);
        Mockito.when(adminSettingService.getAdminSetting()).thenReturn(setting);
        return adminSettingService;
    }

    @Bean
    IAdminSettingDao adminSettingDao() {
        AdminSettingDao mock = Mockito.mock(AdminSettingDao.class);
        Mockito.when(mock.getAdminSetting()).thenReturn(Optional.of(setting));
        return mock;
    }

    @Bean
    IAdminSettingRepository adminSettingRepository() {
        return null;
    }

    @Bean
    EntityFactory entityFactory() {
        return new EntityFactory();
    }
}
