package com.andybrook.service.product;

import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;

import java.util.List;

public interface IProductTypeService {

    void save(Product product);

    Product get(ProductId id);

    boolean isExist(ProductId id);

    Product getByName(String name);

    List<? extends Product> getByNameContaining(String subName);
}
