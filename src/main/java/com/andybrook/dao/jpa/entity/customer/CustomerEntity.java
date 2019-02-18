package com.andybrook.dao.jpa.entity.customer;

import com.andybrook.dao.jpa.entity.store.StoreEntity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "storeId")
    private StoreEntity storeEntity;

    public CustomerEntity() {}

    public CustomerEntity(Long id, StoreEntity storeEntity) {
        this.id = id;
        this.storeEntity = storeEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreEntity getStoreEntity() {
        return storeEntity;
    }

    public void setStoreEntity(StoreEntity storeEntity) {
        this.storeEntity = storeEntity;
    }
}
