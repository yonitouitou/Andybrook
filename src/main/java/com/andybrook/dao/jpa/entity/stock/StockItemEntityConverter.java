package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
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
        return new StockItem(entity.getId(), product, entity.getProductType(), entity.getQuantity());
    }

    @Override
    public StockItemEntity toEntity(StockItem model) {
        return entityFactory.createStockItemEntityByProductType(model);
    }
}
