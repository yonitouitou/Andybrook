package com.andybrook.dao.jpa.entity.product;

import com.andybrook.dao.jpa.entity.stock.BarCodeEntity;
import com.andybrook.enums.ProductType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import static com.andybrook.dao.jpa.entity.product.ProductEntity.DISCRIMINATOR_COLUMN_TYPE;
import static com.andybrook.dao.jpa.entity.product.ProductEntity.TABLE_PRODUCT;

@Entity
@Table(name=TABLE_PRODUCT)
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name=DISCRIMINATOR_COLUMN_TYPE, columnDefinition = "VARCHAR(55)")
@EntityListeners(AuditingEntityListener.class)
public abstract class ProductEntity {

    static final String TABLE_PRODUCT = "product";
    static final String DISCRIMINATOR_COLUMN_TYPE = "type";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "price", nullable = false)
    protected double price;

    @Transient
    @Column(name = "type", nullable = false)
    protected ProductType type;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid")
    protected Set<BarCodeEntity> BarCodeEntities;

    @CreatedDate
    @Column(name = "createddatetime", nullable = false, updatable = false)
    private LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime", nullable = false)
    private LocalDateTime lastModifiedDateTime;

    protected ProductEntity() {
    }

    public ProductEntity(Long id, String name, double price, ProductType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
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

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Set<BarCodeEntity> getBarCodeEntities() {
        return BarCodeEntities;
    }

    public void setBarCodeEntities(Set<BarCodeEntity> barCodeEntities) {
        BarCodeEntities = barCodeEntities;
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
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", BarCodeEntities=" + BarCodeEntities +
                ", createdDatetime=" + createdDatetime +
                ", lastModifiedDateTime=" + lastModifiedDateTime +
                '}';
    }
}
