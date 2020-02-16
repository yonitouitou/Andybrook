package com.andybrook.dao.product;

import com.andybrook.model.product.Glasses;
import com.andybrook.model.product.ProductId;

import java.util.List;
import java.util.Optional;

public interface IGlassesDao {

    void save(Glasses glasses);

    Optional<Glasses> get(ProductId id);

    boolean isExist(ProductId id);

    Optional<Glasses> getByName(String name);

    List<Glasses> getByNameContaining(String subName);
}
