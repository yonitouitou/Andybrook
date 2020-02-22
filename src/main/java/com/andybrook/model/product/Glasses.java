package com.andybrook.model.product;

import com.andybrook.enums.ProductType;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product_glasses")
public class Glasses extends Product {

    private static final ProductType PRODUCT_TYPE = ProductType.GLASSES;

    private Glasses() {
        super();
    }

    public Glasses(String name, double price) {
        super(ProductId.generate(PRODUCT_TYPE), name, price);
    }

    public Glasses(ProductId productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public ProductType getType() {
        return PRODUCT_TYPE;
    }
}
