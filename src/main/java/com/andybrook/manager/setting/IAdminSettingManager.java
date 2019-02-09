package com.andybrook.manager.setting;

import com.andybrook.model.setting.AdminSetting;

public interface IAdminSettingManager {

    AdminSetting getAdminSetting();

    AdminSetting updateAdminSetting(AdminSetting adminSetting);

    boolean shouldNotifyOnCloseReport();
}
