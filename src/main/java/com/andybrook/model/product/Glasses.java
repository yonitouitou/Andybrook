package com.andybrook.model.product;

import com.andybrook.enums.ProductType;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "glasses")
public class Glasses extends Product {

    private Glasses() {
        super();
    }

    public Glasses(Long id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public ProductType getType() {
        return ProductType.GLASSES;
    }
}
