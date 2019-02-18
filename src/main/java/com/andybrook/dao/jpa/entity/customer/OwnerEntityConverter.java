package com.andybrook.dao.jpa.entity.customer;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.customer.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = Owner.class, entity = OwnerEntity.class)
public final class OwnerEntityConverter implements IEntityConverter<Owner, OwnerEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Owner toModel(OwnerEntity entity) {
        return new Owner(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmail());
    }

    @Override
    public OwnerEntity toEntity(Owner model) {
        return new OwnerEntity(model.getId(), model.getFirstName(), model.getLastName(), model.getEmail());
    }
}
