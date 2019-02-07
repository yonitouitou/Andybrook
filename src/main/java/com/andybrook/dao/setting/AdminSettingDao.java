package com.andybrook.dao.setting;

import com.andybrook.dao.jpa.crudrepository.IAdminSettingRepository;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.setting.AdminSettingEntity;
import com.andybrook.model.setting.AdminSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class AdminSettingDao implements IAdminSettingDao {

    @Autowired
    private IAdminSettingRepository adminSettingRepository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public AdminSetting updateAdminSetting(AdminSetting adminSetting) {
        AdminSettingEntity entity = entityFactory.createAdminSettingEntity(adminSetting);
        AdminSettingEntity savedEntity = adminSettingRepository.save(entity);
        return entityFactory.createAdminSetting(savedEntity);
    }

    @Override
    public Optional<AdminSetting> getAdminSetting() {
        Optional<AdminSetting> adminSettingOpt = Optional.empty();
        Iterable<AdminSettingEntity> adminSettings = adminSettingRepository.findAll();
        Iterator<AdminSettingEntity> iterator = adminSettings.iterator();
        if (iterator.hasNext()) {
            AdminSettingEntity entity = iterator.next();
            AdminSetting adminSetting = entityFactory.createAdminSetting(entity);
            adminSettingOpt = Optional.of(adminSetting);
        }
        return adminSettingOpt;
    }
}
