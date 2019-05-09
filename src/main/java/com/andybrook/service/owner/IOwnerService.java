package com.andybrook.service.owner;

import com.andybrook.model.customer.Owner;

import java.util.Map;

public interface IOwnerService {

    Map<Long, Owner> getAll();

    Owner update(Owner owner);
}
