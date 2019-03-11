package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.StockItem;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = StockItem.class, entity = StockItemEntity.class)
public class StockItemEntityConverter implements IEntityConverter<StockItem, StockItemEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public StockItem toModel(StockItemEntity entity) {
        Product product = entityFactory.createProduct(entity.getProductEntity());
        StockItem stockItem = new StockItem(entity.getId(), product, entity.getProductType(), entity.getQuantity());
        if (entity.getBarCodeEntity() != null) {
            stockItem.setBarCode(entityFactory.createBarCode(entity.getBarCodeEntity()));
        }
        return stockItem;
    }

    @Override
    public StockItemEntity toEntity(StockItem model) {
        StockItemEntity entity = entityFactory.createStockItemEntityByProductType(model);
        if (model.getBarCode() != null) {
            entity.setBarCodeEntity(entityFactory.createBarCodeEntity(model.getBarCode()));
        }
        return entity;
    }
}
