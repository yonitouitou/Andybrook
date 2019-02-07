package com.andybrook.service.setting;

import com.andybrook.api.rest.StockItemController;
import com.andybrook.dao.setting.IAdminSettingDao;
import com.andybrook.model.notification.NotificationPolicy;
import com.andybrook.model.setting.AdminSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Optional;

@Service
public class AdminSettingService implements IAdminSettingService {

    private static Logger LOGGER = System.getLogger(AdminSettingService.class.getSimpleName());
    private AdminSetting adminSetting;

    @Autowired
    private IAdminSettingDao adminSettingDao;

    @PostConstruct
    private void init() {
        Optional<AdminSetting> adminSettingOpt = adminSettingDao.getAdminSetting();
        if (adminSettingOpt.isPresent()) {
            adminSetting = adminSettingOpt.get();
        } else {
            LOGGER.log(Level.INFO, "No admin setting found in the database, create default admin setting");
            AdminSetting defaultAdminSetting = adminSettingDao.updateAdminSetting(AdminSetting.getDefaultAdminSetting());
            adminSetting = defaultAdminSetting;
        }
    }

    @Override
    public boolean shouldNotifyOnCloseReport() {
        return adminSetting.getNotificationPolicy().onCloseReport();
    }
}
