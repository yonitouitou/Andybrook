package com.andybrook.dao.jpa.entity.product;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.stock.BarCodeEntity;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Glasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
@EntityConverter(model = Glasses.class, entity = GlassesEntity.class)
public class GlassesEntityConverter implements IEntityConverter<Glasses, GlassesEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Glasses toModel(GlassesEntity entity) {
        return new Glasses(entity.getId(), entity.getName(), entity.getPrice());
    }

    @Override
    public GlassesEntity toEntity(Glasses model) {
        return new GlassesEntity(model.getId(), model.getName(), model.getPrice());
    }
}
