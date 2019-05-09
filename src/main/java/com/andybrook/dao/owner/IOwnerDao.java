package com.andybrook.dao.owner;

import com.andybrook.model.customer.Owner;

import java.util.Map;

public interface IOwnerDao {

    Map<Long, Owner> getAll();

    Owner update(Owner owner);
}
