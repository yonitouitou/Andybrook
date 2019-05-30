package com.andybrook.dao.jpa.entity.store;

import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import com.andybrook.model.common.Address;
import org.hibernate.engine.spi.CascadeStyle;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "store")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "streetnumber")
    private String streetNumber;

    @Column(name = "streetname")
    private String streetName;

    @Column(name = "zipcode")
    private Integer zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private OwnerEntity ownerEntity;

    public StoreEntity() {}

    public StoreEntity(Long id, String name, @Email String email, Address address, String phone, OwnerEntity ownerEntity) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.streetNumber = address.getStreetNumber();
        this.streetName = address.getStreetName();
        this.zipCode = address.getZipCode();
        this.city = address.getCity();
        this.country = address.getCountry();
        this.phone = phone;
        this.ownerEntity = ownerEntity;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public StoreEntity setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public StoreEntity setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public StoreEntity setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public StoreEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public StoreEntity setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }
}
