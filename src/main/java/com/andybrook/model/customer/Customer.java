package com.andybrook.model.customer;

public class Customer {

    private final Long id;
    private final Store store;

    public Customer(Long id, Store store) {
        this.id = id;
        this.store = store;
    }

    public Customer(Store store) {
        this.id = null;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public Store getStore() {
        return store;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", store=").append(store);
        sb.append('}');
        return sb.toString();
    }
}
