package com.andybrook.dao.jpa.entity.factory;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.annotation.ProductConverterByProductType;
import com.andybrook.dao.jpa.entity.customer.CustomerEntity;
import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import com.andybrook.dao.jpa.entity.order.OrderEntity;
import com.andybrook.dao.jpa.entity.order.OrderItemEntity;
import com.andybrook.dao.jpa.entity.order.OrderItemEntityConverter;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.dao.jpa.entity.setting.AdminSettingEntity;
import com.andybrook.dao.jpa.entity.setting.notification.NotificationPolicyEntity;
import com.andybrook.dao.jpa.entity.stock.*;
import com.andybrook.dao.jpa.entity.store.StoreEntity;
import com.andybrook.enums.ProductType;
import com.andybrook.model.BarCode;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import com.andybrook.model.notification.NotificationPolicy;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.setting.AdminSetting;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.model.stock.ProductStockInfo;
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

    public final <T extends Product> T createProduct(ProductEntity entity) {
        IEntityConverter converter = entityConverterMapByProductType.get(entity.getType());
        return (T) converter.toModel(entity);
    }

    public final <T extends ProductEntity> T createProductEntity(Product model) {
        IEntityConverter converter = entityConverterMapByProductType.get(model.getType());
        return (T) converter.toEntity(model);
    }

    public final <T extends ProductItem> T createProductItem(ProductItemEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(entity.getClass());
        return (T) converter.toModel(entity);
    }

    public final <T extends ProductItemEntity> T createProductItemEntity(ProductItem model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (T) converter.toEntity(model);
    }

    public final <T extends Product> OrderItem createOrderItem(OrderItemEntity entity) {
        OrderItemEntityConverter converter = (OrderItemEntityConverter) entityConverterMapByEntityClass.get(entity);
        return converter.toModel(entity);
    }

    public final OrderItemEntity createOrderItemEntityByProductType(OrderEntity orderEntity, OrderItem orderItem) {
        OrderItemEntityConverter converter = (OrderItemEntityConverter) entityConverterMapByModelClass.get(orderItem.getClass());
        return converter.toEntity(orderEntity, orderItem);
    }

    public final OrderEntity createOrderEntity(Order model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (OrderEntity) converter.toEntity(model);
    }

    public final Order createOrder(OrderEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(Hibernate.getClass(entity));
        return (Order) converter.toModel(entity);
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
        IEntityConverter converter = entityConverterMapByEntityClass.get(entity.getClass());
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

    public final CustomerEntity createCustomerEntity(Customer model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (CustomerEntity) converter.toEntity(model);
    }

    public final Customer createCustomer(CustomerEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(entity.getClass());
        return (Customer) converter.toModel(entity);
    }

    public final BarCodeEntity createBarCodeEntity(BarCode model, ProductItemEntity productItemEntity) {
        BarCodeEntityConverter converter = (BarCodeEntityConverter) entityConverterMapByModelClass.get(model.getClass());
        return converter.toEntity(model, productItemEntity);
    }

    public final BarCode createBarCode(BarCodeEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(entity.getClass());
        return (BarCode) converter.toModel(entity);
    }

    public final ProductStockInfo createProductStockInfo(ProductStockInfoEntity entity) {
        IEntityConverter converter = entityConverterMapByEntityClass.get(entity.getClass());
        return (ProductStockInfo) converter.toModel(entity);
    }

    public final ProductStockInfoEntity createProductStockInfoEntity(ProductStockInfo model) {
        IEntityConverter converter = entityConverterMapByModelClass.get(model.getClass());
        return (ProductStockInfoEntity) converter.toEntity(model);
    }
}
