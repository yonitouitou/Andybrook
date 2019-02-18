package com.andybrook.dao.jpa.entity.setting;


import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.setting.notification.NotificationPolicyEntity;
import com.andybrook.model.notification.NotificationPolicy;
import com.andybrook.model.setting.AdminSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
@EntityConverter(model = AdminSetting.class, entity = AdminSettingEntity.class)
public class AdminSettingConverter implements IEntityConverter<AdminSetting, AdminSettingEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public AdminSetting toModel(AdminSettingEntity entity) {
        NotificationPolicy notificationPolicy = entityFactory.createNotificationPolicy(entity.getNotificationPolicyEntity());
        AdminSetting adminSetting = new AdminSetting(entity.getId(), entity.getEmail().split(";"), notificationPolicy, entity.getOrdersNbToShow());
        return adminSetting;
    }

    @Override
    public AdminSettingEntity toEntity(AdminSetting model) {
        NotificationPolicyEntity policyEntity = entityFactory.createNotificationPolicyEntity(model.getNotificationPolicy());
        return new AdminSettingEntity(model.getId(), model.getOrdersNbToShow(), arrayToString(model.getEmails()), policyEntity);
    }

    private String arrayToString(String[] array) {
        StringJoiner sj = new StringJoiner(";");
        for (int i = 0; i < array.length; i++) {
            sj.add(array[i]);
        }
        return sj.toString();
    }
}
