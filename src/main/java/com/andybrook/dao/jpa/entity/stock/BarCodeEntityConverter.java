package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.BarCode;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = BarCode.class, entity = BarCodeEntity.class)
public class BarCodeEntityConverter implements IEntityConverter<BarCode, BarCodeEntity> {

    @Override
    public BarCode toModel(BarCodeEntity entity) {
        return new BarCode(entity.getId());
    }

    @Override
    public BarCodeEntity toEntity(BarCode model) {
        return new BarCodeEntity(model.getId());
    }
}
