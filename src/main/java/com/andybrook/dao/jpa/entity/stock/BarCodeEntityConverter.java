package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.product.ProductEntity;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = BarCode.class, entity = BarCodeEntity.class)
public class BarCodeEntityConverter implements IEntityConverter<BarCode, BarCodeEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public BarCode toModel(BarCodeEntity entity) {
        return new BarCode(entity.getId());
    }

    @Override
    public BarCodeEntity toEntity(BarCode model) {
        throw new UnsupportedOperationException();
    }

    public BarCodeEntity toEntity(BarCode model, ProductEntity productEntity) {
        return new BarCodeEntity(model.getId(), productEntity);
    }
}
