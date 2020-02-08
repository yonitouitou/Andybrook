package com.andybrook.exception;

import com.andybrook.model.product.ProductId;

public class ProductNotFound extends ValidationRuntimeException {

    public ProductNotFound(ProductId id) {
        super("Product not found : " + id);
    }
}
