package com.andybrook.api.pdf;

import com.andybrook.ApplicationProperties;
import com.andybrook.language.LanguageResolver;
import com.andybrook.model.setting.AdminSetting;
import com.andybrook.service.setting.IAdminSettingService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class AbstractPdfBuilder {

    @Autowired
    protected ApplicationProperties applicationProperties;
    @Autowired
    protected LanguageResolver languageResolver;
    @Autowired
    private IAdminSettingService adminSettingService;

    protected AdminSetting adminSetting;

    @PostConstruct
    protected void init() {
        adminSetting = adminSettingService.getAdminSetting();
    }
}
