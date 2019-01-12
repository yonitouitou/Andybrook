package com.andybrook.dao.glasses;

import com.andybrook.dao.glasses.jpa.GlassesEntity;
import com.andybrook.dao.glasses.jpa.IGlassesCrudRepository;
import com.andybrook.model.Glasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlassesDao implements IGlassesDao {

    @Autowired
    private IGlassesCrudRepository glassesCrudRepository;

    @Override
    public Glasses updateGlasses(Glasses glasses) {
        GlassesEntity entity = GlassesEntity.newInstance(glasses);
        GlassesEntity savedEntity = glassesCrudRepository.save(entity);
        glasses.setId(savedEntity.getId());
        return glasses;
    }

    @Override
    public boolean removeGlasses(long id) {
        return false;
    }
}
