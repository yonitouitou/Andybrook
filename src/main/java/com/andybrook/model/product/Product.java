package com.andybrook.model.product;

import com.andybrook.enums.ProductType;
import com.andybrook.serialization.jackson.custom.ProductDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.data.annotation.Id;

import java.util.Objects;

@JsonDeserialize(using = ProductDeserializer.class)
public abstract class Product {

    @Id
    protected ProductId id;
    protected String name;
    protected double price;

    public abstract ProductType getType();

    protected Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = new ProductId(id);
        this.name = name;
        this.price = price;
    }

    public ProductId getId() {
        return id;
    }

    public void setId(long id) {
        this.id = new ProductId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
