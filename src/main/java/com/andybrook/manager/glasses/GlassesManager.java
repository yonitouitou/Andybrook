package com.andybrook.manager.glasses;

import com.andybrook.model.Glasses;
import com.andybrook.service.glasses.IGlassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GlassesManager implements IGlassesManager {

    private static final String GLASSES_NULL_ERROR = "Glasses must not be null";

    @Autowired
    private IGlassesService glassesService;

    @Override
    public void updateGlasses(Glasses glasses) {
        Objects.requireNonNull(glasses, GLASSES_NULL_ERROR);
        glassesService.updateGlasses(glasses);
    }
}
