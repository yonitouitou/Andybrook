package com.andybrook.manager.setting;

import com.andybrook.model.setting.AdminSetting;
import com.andybrook.service.setting.IAdminSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSettingManager implements IAdminSettingManager {

    @Autowired
    private IAdminSettingService adminSettingService;

    @Override
    public AdminSetting getAdminSetting() {
        return adminSettingService.getAdminSetting();
    }

    @Override
    public AdminSetting updateAdminSetting(AdminSetting adminSetting) {
        return adminSettingService.updateAdminSetting(adminSetting);
    }

    @Override
    public boolean shouldNotifyOnCloseReport() {
        return adminSettingService.shouldNotifyOnCloseReport();
    }
}