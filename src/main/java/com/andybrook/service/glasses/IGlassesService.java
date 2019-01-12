package com.andybrook.service.glasses;

import com.andybrook.model.Glasses;

public interface IGlassesService {

    Glasses newGlasses(Glasses glasses);

    Glasses updateGlasses(Glasses glasses);

    boolean removeGlasses(long id);
}
