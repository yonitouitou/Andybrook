package com.andybrook.dao.jpa.entity.factory;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.annotation.ProductConverterByProductType;
import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import com.andybrook.dao.jpa.entity.setting.AdminSettingEntity;
import com.andybrook.dao.jpa.entity.setting.notification.NotificationPolicyEntity;
import com.andybrook.dao.jpa.entity.store.StoreEntity;
import com.andybrook.enums.ProductType;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.notification.NotificationPolicy;
import com.andybrook.model.setting.AdminSetting;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

@Component
@SuppressWarnings("unchecked")
public final class EntityFactory {

    private static Logger LOGGER = System.getLogger(EntityFactory.class.getSimpleName());
    private Map<Class, IEntityConverter> entityConverterMapByModelClass = new HashMap<>();
    private Map<Class, IEntityConverter> entityConverterMapByEntityClass = new HashMap<>();
    private Map<ProductType, IEntityConverter> entityConverterMapByProductType = new EnumMap(ProductType.class);

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init() {
        Map<String, IEntityConverter> converters = applicationContext.getBeansOfType(IEntityConverter.class);
        for (IEntityConverter converter : converters.values()) {
            Class<?> theClass = converter.getClass();
            EntityConverter annotation = theClass.getAnnotation(EntityConverter.class);
            if (annotation != null) {
                entityConverterMapByModelClass.put(annotation.model(), converter);
                entityConverterMapByEntityClass.put(annotation.entity(), converter);
            } else {
                LOGGER.log(Level.WARNING, "Entity converter found without the annotation "
                        + EntityConverter.class.getSimpleName() + " : " + theClass.getName());
            }
        }

        for (IEntityConverter converter : converters.values()) {
            Class<?> theClass = converter.getClass();
            ProductConverterByProductType annotation = theClass.getAnnotation(ProductConverterByProductType.class);
            if (annotation != null) {
                entityConverterMapByProductType.put(annotation.type(), converter);
            } else {
                LOGGER.log(Level.WARNING, "Entity converter found without the annotation "
                        + ProductConverterByProductType.class.getSimpleName() + " : " + theClass.getName());
            }
        }
    }

    public final AdminSetting createAdminSetting(AdminSettingEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(entity.getClass());
        return (AdminSetting) converter.toModel(entity);
    }

    public final AdminSettingEntity createAdminSettingEntity(AdminSetting model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (AdminSettingEntity) converter.toEntity(model);
    }

    public final NotificationPolicy createNotificationPolicy(NotificationPolicyEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(entity.getClass());
        return (NotificationPolicy) converter.toModel(entity);
    }

    public final NotificationPolicyEntity createNotificationPolicyEntity(NotificationPolicy model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (NotificationPolicyEntity) converter.toEntity(model);
    }

    public final OwnerEntity createOwnerEntity(Owner model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (OwnerEntity) converter.toEntity(model);
    }

    public final Owner createOwner(OwnerEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(Hibernate.getClass(entity));
        return (Owner) converter.toModel(entity);
    }

    public final StoreEntity createStoreEntity(Store model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (StoreEntity) converter.toEntity(model);
    }

    public final Store createStore(StoreEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(entity.getClass());
        return (Store) converter.toModel(entity);
    }
}
