package com.andybrook.service.product;

import com.andybrook.exception.BarCodeAlreadyExist;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.product.Product;

public interface IProductService {

    Product addProduct(Product product);

    void addBarCode(long productId, BarCode barCode) throws BarCodeAlreadyExist, ProductNotFound;
}
