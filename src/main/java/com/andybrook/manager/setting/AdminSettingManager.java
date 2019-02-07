package com.andybrook.manager.setting;

import com.andybrook.service.setting.IAdminSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSettingManager implements IAdminSettingManager {

    @Autowired
    private IAdminSettingService adminSettingService;

    @Override
    public boolean shouldNotifyOnCloseReport() {
        return adminSettingService.shouldNotifyOnCloseReport();
    }
}
