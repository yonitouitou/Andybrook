package com.andybrook.dao.glasses;

import com.andybrook.model.Glasses;

public interface IGlassesDao {

    Glasses updateGlasses(Glasses glasses);

    boolean removeGlasses(long id);


}
