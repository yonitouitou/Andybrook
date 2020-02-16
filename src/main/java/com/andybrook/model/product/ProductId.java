package com.andybrook.model.product;

import com.andybrook.enums.ProductType;

import java.util.Objects;

public final class ProductId {

    private static final String SEPARATOR = "-";
    private final String id;
    private final ProductType productType;

    private ProductId() {
        this.id = null;
        this.productType = null;
    }

    public ProductId(ProductType type, long id) {
        this.id = type.getSymbol() + "-" + id;
        this.productType = type;
    }

    private ProductId(ProductType type, String id) {
        this.id = type.getSymbol() + SEPARATOR + id;
        this.productType = type;
    }

    public static ProductId from(String id) {
        String[] split = id.split(SEPARATOR);
        return new ProductId(ProductType.getBySymbol(split[0]), split[1]);
    }
    public String get() {
        return id;
    }

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return id.equals(productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
