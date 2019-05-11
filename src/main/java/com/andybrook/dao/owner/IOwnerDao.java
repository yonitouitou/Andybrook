package com.andybrook.dao.owner;

import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import com.andybrook.model.customer.Owner;

import java.util.Map;
import java.util.Optional;

public interface IOwnerDao {

    Optional<Owner> get(long ownerId);

    OwnerEntity getOne(long ownerId);

    Map<Long, Owner> getAll();

    Owner update(Owner owner);
}
