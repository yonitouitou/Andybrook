package com.andybrook.manager.owner;

import com.andybrook.model.customer.Owner;
import com.andybrook.service.owner.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OwnerManager implements IOwnerManager {

    @Autowired
    private IOwnerService ownerService;

    @Override
    public Map<Long, Owner> getAll() {
        return ownerService.getAll();
    }
}
