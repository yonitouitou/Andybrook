package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.order.OrderItemEntity;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = ProductItem.class, entity = ProductItemEntity.class)
public class ProductItemEntityConverter implements IEntityConverter<ProductItem, ProductItemEntity> {

    @Autowired
    private EntityFactory entityFactory;
    @Override
    public ProductItem toModel(ProductItemEntity entity) {
        Product product = entityFactory.createProduct(entity.getProductEntity());
        BarCode barCode = null;
        if (entity.getBarCodeEntity() != null) {
            barCode = entityFactory.createBarCode(entity.getBarCodeEntity());
        }
        ProductItem productItem = new ProductItem(entity.getId(), product, barCode);
        productItem.setCreatedDatetime(entity.getCreatedDatetime());
        productItem.setLastModifiedDatetime(entity.getLastModifiedDatetime());
        Long orderItemId = entity.getOrderItemEntity() != null
                ? entity.getOrderItemEntity().getId()
                : null;
            productItem.setOrderItemId(orderItemId);
        return productItem;
    }

    @Override
    public ProductItemEntity toEntity(ProductItem model) {
        throw new UnsupportedOperationException();
    }

    public ProductItemEntity toEntity(ProductItem model, OrderItemEntity orderItemEntity) {
        ProductItemEntity entity = new ProductItemEntity(model.getId(), model.getCreatedDatetime(), model.getLastModifiedDatetime());
        ProductEntity productEntity = entityFactory.createProductEntity(model.getProduct());
        entity.setProductEntity(productEntity);
        entity.setOrderItemEntity(orderItemEntity);
        BarCodeEntity barCodeEntity;
        if (model.getBarCode() != null) {
            barCodeEntity = entityFactory.createBarCodeEntity(model.getBarCode(), entity);
            entity.setBarCodeEntity(barCodeEntity);
        }
        return entity;
    }


}
