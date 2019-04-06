package com.andybrook.service.product;

import com.andybrook.exception.BarCodeAlreadyExist;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IProductService {

    Product get(long id) throws ProductNotFound;

    Product update(Product product);

    List<? extends Product> getByNameContaining(String subName);

    Product addProduct(Product product);

    void addBarCode(long productId, BarCode barCode) throws BarCodeAlreadyExist, ProductNotFound;

    List<Pair<Long, String>> getAllProductNamesWithQuantityMoreThan(int quantity);
}
