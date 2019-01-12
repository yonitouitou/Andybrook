package com.andybrook.dao.glasses;

import com.andybrook.dao.glasses.jpa.GlassesEntity;
import com.andybrook.dao.glasses.jpa.IGlassesCrudRepository;
import com.andybrook.model.Glasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GlassesDao implements IGlassesDao {

    @Autowired
    private IGlassesCrudRepository glassesCrudRepository;

    @Override
    public Optional<Glasses> getGlasses(Long id) {
        Optional<Glasses> glassesOpt = Optional.empty();
        Optional<GlassesEntity> glassesEntityOpt = glassesCrudRepository.findById(id);
        if (glassesEntityOpt.isPresent()) {
            Glasses glasses = GlassesEntity.toModel(glassesEntityOpt.get());
            glassesOpt = Optional.of(glasses);
        }
        return glassesOpt;
    }

    @Override
    public Glasses updateGlasses(Glasses glasses) {
        GlassesEntity entity = GlassesEntity.toEntity(glasses);
        GlassesEntity savedEntity = glassesCrudRepository.save(entity);
        glasses.setId(savedEntity.getId());
        return glasses;
    }

    @Override
    public boolean removeGlasses(long id) {
        glassesCrudRepository.deleteById(id);
        return true;
    }
}
