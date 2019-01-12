package com.andybrook.service.glasses;

import com.andybrook.dao.glasses.IGlassesDao;
import com.andybrook.model.Glasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlassesService implements IGlassesService {

    @Autowired
    private IGlassesDao dao;

    @Override
    public Glasses newGlasses(Glasses glasses) {
        return dao.updateGlasses(glasses);
    }

    @Override
    public Glasses updateGlasses(Glasses glasses) {
        return dao.updateGlasses(glasses);
    }

    @Override
    public boolean removeGlasses(long id) {
        return dao.removeGlasses(id);
    }
}
