package com.andybrook.dao.setting;

import com.andybrook.dao.jpa.entity.setting.AdminSettingEntity;
import org.springframework.data.repository.CrudRepository;

public interface IAdminSettingRepository extends CrudRepository<AdminSettingEntity, Long> {

}