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
        Glasses glasses = new Glasses(entity.getId(), entity.getName(), entity.getPrice());
        glasses.setQuantityCreated(entity.getQuantityCreated());
        glasses.setQuantityUsed(entity.getQuantityUsed());
        if (entity.getBarCodeEntities() != null) {
            Map<String, BarCode> barCodes = new HashMap<>(entity.getBarCodeEntities().size());
            for (BarCodeEntity barCodeEntity : entity.getBarCodeEntities()) {
                BarCode barCode = entityFactory.createBarCode(barCodeEntity);
                barCodes.put(barCode.getId(), barCode);
            }
            glasses.setBarCodes(barCodes);
        }
        return glasses;
    }

    @Override
    public GlassesEntity toEntity(Glasses model) {
        GlassesEntity entity = new GlassesEntity(model.getId(), model.getName(), model.getPrice(), model.getQuantityCreated(), model.getQuantityUsed());
        if (model.getBarCodes() != null) {
            Set<BarCodeEntity> barCodeEntities = new HashSet<>(model.getBarCodes().size());
            for (BarCode barCode : model.getBarCodes().values()) {
                barCodeEntities.add(entityFactory.createBarCodeEntity(entity, barCode));
            }
            entity.setBarCodeEntities(barCodeEntities);
        }
        return entity;
    }
}
