package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.BarCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = BarCode.class, entity = BarCodeEntity.class)
public class BarCodeEntityConverter implements IEntityConverter<BarCode, BarCodeEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public BarCode toModel(BarCodeEntity entity) {
        BarCode barCode = new BarCode(entity.getId());
        if (entity.getProductItemEntity() != null) {
            barCode.setUsed(true);
        }
        return barCode;
    }

    @Override
    public BarCodeEntity toEntity(BarCode model) {
        throw new UnsupportedOperationException();
    }

    public BarCodeEntity toEntity(BarCode model, ProductItemEntity productItemEntity) {
        return new BarCodeEntity(model.getId(), productItemEntity);
    }
}
