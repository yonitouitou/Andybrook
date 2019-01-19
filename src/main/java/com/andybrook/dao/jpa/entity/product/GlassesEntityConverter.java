package com.andybrook.dao.jpa.entity.product;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.Glasses;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = Glasses.class, entity = GlassesEntity.class)
public class GlassesEntityConverter implements IEntityConverter<Glasses, GlassesEntity> {

    @Override
    public Glasses toModel(GlassesEntity entity) {
        return new Glasses(entity.getId(), entity.getName(), entity.getPrice());
    }

    @Override
    public GlassesEntity toEntity(Glasses model) {
        return new GlassesEntity(model.getId(), model.getName(), model.getPrice());
    }
}
