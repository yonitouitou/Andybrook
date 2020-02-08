package com.andybrook.model.product;

import java.util.Objects;

public final class ProductId {

    private final long id;

    public ProductId(long id) {
        this.id = id;
    }

    public long get() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return id == productId.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductId{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
