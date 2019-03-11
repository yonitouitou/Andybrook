package com.andybrook.dao.jpa.entity.product;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.dao.jpa.entity.stock.BarCodeEntity;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Glasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@EntityConverter(model = Glasses.class, entity = GlassesEntity.class)
public class GlassesEntityConverter implements IEntityConverter<Glasses, GlassesEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Glasses toModel(GlassesEntity entity) {
        Glasses glasses = new Glasses(entity.getId(), entity.getName(), entity.getPrice());
        Set<BarCode> barCodes = new HashSet<>(entity.getBarCodeEntities().size());
        for (BarCodeEntity barCodeEntity : entity.getBarCodeEntities()) {
            barCodes.add(entityFactory.createBarCode(barCodeEntity));
        }
        glasses.setBarCodes(barCodes);
        return glasses;
    }

    @Override
    public GlassesEntity toEntity(Glasses model) {
        Set<BarCodeEntity> barCodeEntities = new HashSet<>(model.getBarCodes().size());
        GlassesEntity entity = new GlassesEntity(model.getId(), model.getName(), model.getPrice());
        for (BarCode barCode : model.getBarCodes()) {
            barCodeEntities.add(entityFactory.createBarCodeEntity(barCode));
        }
        entity.setBarCodeEntities(barCodeEntities);
        return entity;
    }
}
