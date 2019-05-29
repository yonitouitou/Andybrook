package com.andybrook.model.customer;

import com.andybrook.model.common.Address;

public class Store {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Address address;
    private Owner owner;

    public Store(String name, String email, String phone, Address address, Owner owner) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.owner = owner;
    }

    public Store(Long id, String name, String email, String phone, Address address, Owner owner) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.owner = owner;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", owner=" + owner +
                '}';
    }
}
