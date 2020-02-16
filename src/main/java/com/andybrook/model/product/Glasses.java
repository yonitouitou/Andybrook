package com.andybrook.model.product;

import com.andybrook.enums.ProductType;
import com.andybrook.util.IdGenerator;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product_glasses")
public class Glasses extends Product {

    private Glasses() {
        super();
    }

    public Glasses(String name, double price) {
        super(IdGenerator.generateId(), name, price);
    }

    public Glasses(long id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public ProductType getType() {
        return ProductType.GLASSES;
    }
}
