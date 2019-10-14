package com.andybrook.manager.owner;

import com.andybrook.model.customer.Owner;

import java.util.Map;

public interface IOwnerManager {

    Map<Long, Owner> getAll();
}
