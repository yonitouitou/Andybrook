package com.andybrook.dao.glasses.jpa;

import com.andybrook.model.Glasses;

import javax.persistence.*;

@Entity
@Table(name="product_glasses")
public class GlassesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;

    private GlassesEntity() {
    }

    private GlassesEntity(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static GlassesEntity toEntity(Glasses glasses) {
        return new GlassesEntity(glasses.getId(), glasses.getName(), glasses.getPrice());
    }

    public static Glasses toModel(GlassesEntity entity) {
        return new Glasses(entity.getId(), entity.getName(), entity.getPrice());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Glasses{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
