package com.andybrook.model.request.customer;

import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Owner;
import com.andybrook.model.customer.Store;

import static com.andybrook.util.Arg.requireNonNullOrEmpty;

public class AddCustomerRequest {

    private final String ownerFirstName;
    private final String ownerLastName;
    private final String ownerEmail;

    private final String storeName;
    private final String storeAddress;
    private final String storePhone;
    private final String storeEmail;

    private AddCustomerRequest(Builder builder) {
        ownerFirstName = builder.ownerFirstName;
        ownerLastName = builder.ownerLastName;
        ownerEmail = builder.ownerEmail;
        storeName = builder.storeName;
        storeAddress = builder.storeAddress;
        storePhone = builder.storePhone;
        storeEmail = builder.storeEmail;
    }

    public static Builder builder(String ownerFirstName, String ownerLastName, String storeName) {
        requireNonNullOrEmpty(ownerFirstName);
        requireNonNullOrEmpty(ownerLastName);
        requireNonNullOrEmpty(storeName);
        return new Builder(ownerFirstName, ownerLastName, storeName);
    }

    public Customer toCustomer() {
        Owner owner = new Owner(ownerFirstName, ownerLastName, ownerEmail);
        Store store = new Store(storeName, storeEmail, storeAddress, storePhone, owner);
        return new Customer(store);
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public static class Builder {

        private String ownerFirstName;
        private String ownerLastName;
        private String ownerEmail;

        private String storeName;
        private String storeAddress;
        private String storePhone;
        private String storeEmail;

        private Builder() {}

        public Builder(String ownerFirstName, String ownerLastName, String storeName) {
            this.storeName = storeName;
            this.ownerFirstName = ownerFirstName;
            this.ownerLastName = ownerLastName;
        }

        public AddCustomerRequest build() {
            return new AddCustomerRequest(this);
        }

        public String getOwnerFirstName() {
            return ownerFirstName;
        }

        public String getOwnerLastName() {
            return ownerLastName;
        }

        public String getOwnerEmail() {
            return ownerEmail;
        }

        public Builder setOwnerEmail(String ownerEmail) {
            this.ownerEmail = ownerEmail;
            return this;
        }

        public String getStoreAddress() {
            return storeAddress;
        }

        public Builder setStoreAddress(String storeAddress) {
            this.storeAddress = storeAddress;
            return this;
        }

        public String getStorePhone() {
            return storePhone;
        }

        public Builder setStorePhone(String storePhone) {
            this.storePhone = storePhone;
            return this;
        }

        public String getStoreEmail() {
            return storeEmail;
        }

        public Builder setStoreEmail(String storeEmail) {
            this.storeEmail = storeEmail;
            return this;
        }
    }

}
