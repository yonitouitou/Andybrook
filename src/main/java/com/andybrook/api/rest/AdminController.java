package com.andybrook.api.rest;

import com.andybrook.manager.setting.IAdminSettingManager;
import com.andybrook.model.notification.NotificationPolicy;
import com.andybrook.model.request.UpdateAdminSettingRequest;
import com.andybrook.model.setting.AdminSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/admin")
public class AdminController {

    @Autowired
    private IAdminSettingManager adminSettingManager;

    @GetMapping(path = "/setting/get")
    public AdminSetting getAdminSetting() {
        return adminSettingManager.getAdminSetting();
    }

    @PostMapping(path = "/setting/update")
    public AdminSetting updateAdminSetting(@RequestBody UpdateAdminSettingRequest request) {
        return adminSettingManager.updateAdminSetting(request.toAdminSetting());
    }
}
