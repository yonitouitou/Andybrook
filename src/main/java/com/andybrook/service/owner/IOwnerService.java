package com.andybrook.service.owner;

import com.andybrook.exception.OwnerNotFound;
import com.andybrook.model.customer.Owner;

import java.util.Map;

public interface IOwnerService {

    void newOwner(Owner owner);

    Owner get(long ownerId);

    Map<Long, Owner> getAll();

    void update(Owner owner) throws OwnerNotFound;
}
