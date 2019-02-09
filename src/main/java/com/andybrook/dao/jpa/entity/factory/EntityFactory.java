package com.andybrook.dao.jpa.entity.factory;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.annotation.StockItemEntityConverterByProductType;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.dao.jpa.entity.setting.AdminSettingEntity;
import com.andybrook.dao.jpa.entity.setting.notification.NotificationPolicyEntity;
import com.andybrook.dao.jpa.entity.stock.StockItemEntity;
import com.andybrook.dao.jpa.entity.stock.StockReportEntity;
import com.andybrook.enums.ProductType;
import com.andybrook.model.StockItem;
import com.andybrook.model.StockReport;
import com.andybrook.model.notification.NotificationPolicy;
import com.andybrook.model.product.Product;
import com.andybrook.model.setting.AdminSetting;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Component
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
            StockItemEntityConverterByProductType annotation = theClass.getAnnotation(StockItemEntityConverterByProductType.class);
            if (annotation != null) {
                entityConverterMapByProductType.put(annotation.type(), converter);
            } else {
                LOGGER.log(Level.WARNING, "Entity converter found without the annotation "
                        + StockItemEntityConverterByProductType.class.getSimpleName() + " : " + theClass.getName());
            }
        }
    }

    public final <T extends ProductEntity> T createProductEntity(Product model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (T) converter.toEntity(model);
    }

    public final <T extends Product> T createProduct(ProductEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(entity.getClass());
        return (T) converter.toModel(entity);
    }

    public final <T extends Product> StockItemEntity createStockItemEntity(StockItem<T> model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (StockItemEntity) converter.toEntity(model);
    }

    public final <T extends Product> StockItem<T> createStockItem(StockItemEntity entity) {
        IEntityConverter converter = entityConverterMapByProductType.get(entity.getProductType());
        return (StockItem<T>) converter.toModel(entity);
    }

    public final StockItemEntity createStockItemEntityByProductType(StockItem stockItem) {
        IEntityConverter converter = entityConverterMapByProductType.get(stockItem.getType());
        return (StockItemEntity) converter.toEntity(stockItem);
    }

    public final StockReportEntity createStockReportEntity(StockReport model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (StockReportEntity) converter.toEntity(model);
    }

    public final StockReport createStockReport(StockReportEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(Hibernate.getClass(entity));
        return (StockReport) converter.toModel(entity);
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
}
