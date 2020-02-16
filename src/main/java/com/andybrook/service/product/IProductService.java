package com.andybrook.service.product;

import com.andybrook.enums.ProductType;
import com.andybrook.model.product.Product;
import com.andybrook.model.product.ProductId;

import java.util.List;

public interface IProductService {

    void add(Product product);

    Product get(ProductId id);

    boolean isExist(ProductId id);

    Product getByName(ProductType type, String name);

    List<? extends Product> getByNameContaining(ProductType type, String subName);
}
