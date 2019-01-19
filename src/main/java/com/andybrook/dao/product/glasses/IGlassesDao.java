package com.andybrook.dao.product.glasses;

import com.andybrook.model.Glasses;

import java.util.Optional;

public interface IGlassesDao {

    Optional<Glasses> getGlasses(Long id);

    Glasses updateGlasses(Glasses glasses);

    boolean removeGlasses(long id);


}
