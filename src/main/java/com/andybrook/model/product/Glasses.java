package com.andybrook.model.product;

import com.andybrook.enums.ProductType;

public class Glasses extends Product {

    public Glasses(Long id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public ProductType getType() {
        return ProductType.GLASSES;
    }
}
