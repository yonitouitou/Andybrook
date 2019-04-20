package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.model.product.Product;
import com.andybrook.model.stock.ProductStockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = ProductStockInfo.class, entity = ProductStockInfoEntity.class)
public class ProductStockInfoEntityConverter implements IEntityConverter<ProductStockInfo, ProductStockInfoEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public ProductStockInfo toModel(ProductStockInfoEntity entity) {
        Product product = entityFactory.createProduct(entity.getProductEntity());
        return new ProductStockInfo(product, entity.getQuantityCreated(), entity.getQuantityUsed());
    }

    @Override
    public ProductStockInfoEntity toEntity(ProductStockInfo model) {
        ProductEntity productEntity = entityFactory.createProductEntity(model.getProduct());
        return new ProductStockInfoEntity(productEntity, model.getQuantityCreated(), model.getQuantityUsed());
    }
}
