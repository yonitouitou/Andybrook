package com.andybrook.service.setting;

import com.andybrook.model.setting.AdminSetting;

public interface IAdminSettingService {

    AdminSetting getAdminSetting();

    AdminSetting updateAdminSetting(AdminSetting adminSetting);

    boolean shouldNotifyOnCloseReport();
}
