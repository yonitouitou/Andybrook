package com.andybrook.dao.glasses.jpa;

import com.andybrook.model.Glasses;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="product_glasses")
@EntityListeners(AuditingEntityListener.class)
public class GlassesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @CreatedDate
    @Column(name = "createddatetime", nullable = false)
    private LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime", nullable = false)
    private LocalDateTime lastModifiedDateTime;

    public GlassesEntity() {
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

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
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
