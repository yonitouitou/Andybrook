package com.andybrook.service.owner;

import com.andybrook.dao.owner.IOwnerDao;
import com.andybrook.model.customer.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OwnerService implements IOwnerService {

    @Autowired
    private IOwnerDao dao;

    @Override
    public Map<Long, Owner> getAll() {
        return dao.getAll();
    }

    @Override
    public Owner update(Owner owner) {
        return dao.update(owner);
    }
}
