package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.StockItemEntityConverterByProductType;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.product.GlassesEntity;
import com.andybrook.enums.ProductType;
import com.andybrook.model.product.Glasses;
import com.andybrook.model.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@StockItemEntityConverterByProductType(type = ProductType.GLASSES)
public class GlassesStockItemEntityConverter implements IEntityConverter<StockItem<Glasses>, GlassesStockItemEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public StockItem<Glasses> toModel(GlassesStockItemEntity entity) {
        Glasses glasses = entityFactory.createProduct(entity.getProductEntity());
        return new StockItem(entity.getId(), glasses, ProductType.GLASSES, entity.getQuantity());
    }

    @Override
    public GlassesStockItemEntity toEntity(StockItem<Glasses> model) {
        GlassesEntity glassesEntity = entityFactory.createProductEntity(model.getProduct());
        return new GlassesStockItemEntity(model.getId(), glassesEntity, model.getQuantity());
    }
}
