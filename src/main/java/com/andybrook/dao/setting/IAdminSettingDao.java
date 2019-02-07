package com.andybrook.dao.setting;

import com.andybrook.model.setting.AdminSetting;

import java.util.Optional;

public interface IAdminSettingDao {

    Optional<AdminSetting> getAdminSetting();

    AdminSetting updateAdminSetting(AdminSetting adminSetting);
}
