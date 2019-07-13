package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.model.stock.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EntityConverter(model = StockItemsFileUpload.class, entity = StockItemFileUploadEntity.class)
public class StockItemFileUploadEntityConverter implements IEntityConverter<StockItemsFileUpload, StockItemFileUploadEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public StockItemsFileUpload toModel(StockItemFileUploadEntity entity) {
        List<ProductItem> items = new ArrayList<>(entity.getProducts().size());
        for (ProductItemEntity itemEntity : entity.getProducts()) {
            items.add(entityFactory.createProductItem(itemEntity));
        }
        return new StockItemsFileUpload(entity.getId(), entity.getRowsInFile(), entity.getRowsProcessed(), items, entity.getUploadDateTime());
    }

    @Override
    public StockItemFileUploadEntity toEntity(StockItemsFileUpload model) {
        List<ProductItemEntity> itemEntities = new ArrayList<>(model.getProductItems().size());
        for (ProductItem item : model.getProductItems()) {
            itemEntities.add(entityFactory.createProductItemEntity(item, null));
        }
        return new StockItemFileUploadEntity(model.getId(), model.getRowsInFile(), model.getRowsProcessed(), itemEntities, model.getUploadDateTime());
    }
}
