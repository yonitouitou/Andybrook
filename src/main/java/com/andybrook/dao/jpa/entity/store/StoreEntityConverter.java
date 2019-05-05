package com.andybrook.dao.jpa.entity.store;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = Store.class, entity = StoreEntity.class)
public class StoreEntityConverter implements IEntityConverter<Store, StoreEntity> {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public Store toModel(StoreEntity entity) {
        Owner owner = entityFactory.createOwner(entity.getOwnerEntity());
        return new Store(entity.getId(), entity.getName(), entity.getEmail(), entity.getAddress(), entity.getPhone(), owner);
    }

    @Override
    public StoreEntity toEntity(Store model) {
        OwnerEntity ownerEntity = entityFactory.createOwnerEntity(model.getOwner());
        return new StoreEntity(model.getId(), model.getName(), model.getEmail(), model.getAddress(), model.getPhone(), ownerEntity);
    }
}
