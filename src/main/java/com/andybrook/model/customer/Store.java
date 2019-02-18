package com.andybrook.model.customer;

public class Store {

    private Long id;
    private String name;
    private String email;
    private String address;
    private Owner owner;

    public Store(String name, String email, String address, Owner owner) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.address = address;
        this.owner = owner;
    }

    public Store(Long id, String name, String email, String address, Owner owner) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Store{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", owner=").append(owner);
        sb.append('}');
        return sb.toString();
    }
}
