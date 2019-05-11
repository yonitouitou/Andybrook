package com.andybrook.model.request.customer;

import static com.andybrook.util.Arg.requireNonNullOrEmpty;

public class AddCustomerRequest {

    private final Long ownerId;
    private final String ownerCompagnyName;
    private final String ownerFirstName;
    private final String ownerLastName;
    private final String ownerEmail;

    private final String storeName;
    private final String storeAddress;
    private final String storePhone;
    private final String storeEmail;

    private AddCustomerRequest(Builder builder) {
        ownerId = builder.ownerId;
        ownerCompagnyName = builder.ownerCompagnyName;
        ownerFirstName = builder.ownerFirstName;
        ownerLastName = builder.ownerLastName;
        ownerEmail = builder.ownerEmail;
        storeName = builder.storeName;
        storeAddress = builder.storeAddress;
        storePhone = builder.storePhone;
        storeEmail = builder.storeEmail;
    }

    public static Builder builder(String ownerCompagnyName, String storeName) {
        requireNonNullOrEmpty(ownerCompagnyName);
        requireNonNullOrEmpty(storeName);
        return new Builder(ownerCompagnyName, storeName);
    }

    public static Builder builder(long ownerId, String storeName) {
        requireNonNullOrEmpty(storeName);
        return new Builder(ownerId, storeName);
    }

    public Long getOwnerId() {
        return ownerId;
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

    public String getOwnerCompagnyName() {
        return ownerCompagnyName;
    }

    public static class Builder {

        private Long ownerId;
        private String ownerCompagnyName;
        private String ownerFirstName;
        private String ownerLastName;
        private String ownerEmail;

        private String storeName;
        private String storeAddress;
        private String storePhone;
        private String storeEmail;

        private Builder() {}

        public Builder(String ownerCompagnyName, String storeName) {
            this.storeName = storeName;
            this.ownerCompagnyName = ownerCompagnyName;
        }

        public Builder(long ownerId, String storeName) {
            this.storeName = storeName;
            this.ownerId = ownerId;
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

        public Long getOwnerId() {
            return ownerId;
        }

        public String getStoreName() {
            return storeName;
        }

        public Builder setStoreEmail(String storeEmail) {
            this.storeEmail = storeEmail;
            return this;
        }

        public String getOwnerCompagnyName() {
            return ownerCompagnyName;
        }

        public Builder setOwnerFirstName(String ownerFirstName) {
            this.ownerFirstName = ownerFirstName;
            return this;
        }

        public Builder setOwnerLastName(String ownerLastName) {
            this.ownerLastName = ownerLastName;
            return this;
        }
    }

}
