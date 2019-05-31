package com.andybrook.service.owner;

import com.andybrook.model.customer.Owner;

import java.util.Map;

public interface IOwnerService {

    Owner get(long ownerId);

    Map<Long, Owner> getAll();

    void update(Owner owner);
}
