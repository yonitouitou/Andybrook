package com.andybrook.model.request.customer;

import com.andybrook.model.common.Address;

import static com.andybrook.util.Arg.requireNonNullOrEmpty;

public class AddCustomerRequest {

    private final Long ownerId;
    private final String ownerCompagnyName;
    private final String ownerFirstName;
    private final String ownerLastName;
    private final String ownerEmail;

    private final String storeName;
    private final String storePhone;
    private final String storeEmail;
    private final Address storeAddress;

    private AddCustomerRequest(Builder builder) {
        ownerId = builder.ownerId;
        ownerCompagnyName = builder.ownerCompagnyName;
        ownerFirstName = builder.ownerFirstName;
        ownerLastName = builder.ownerLastName;
        ownerEmail = builder.ownerEmail;
        storeName = builder.storeName;
        storePhone = builder.storePhone;
        storeEmail = builder.storeEmail;
        storeAddress = new Address(builder.storeStreetNumber, builder.storeStreetName,
                builder.storeCity, builder.storeCountry, builder.storeZipCode);
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

    public Address getStoreAddress() {
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
        private String storePhone;
        private String storeEmail;
        private String storeStreetNumber;
        private String storeStreetName;
        private String storeCity;
        private String storeCountry;
        private int storeZipCode;

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

        public Builder setStoreName(String storeName) {
            this.storeName = storeName;
            return this;
        }

        public String getStoreStreetNumber() {
            return storeStreetNumber;
        }

        public Builder setStoreStreetNumber(String storeStreetNumber) {
            this.storeStreetNumber = storeStreetNumber;
            return this;
        }

        public String getStoreStreetName() {
            return storeStreetName;
        }

        public Builder setStoreStreetName(String storeStreetName) {
            this.storeStreetName = storeStreetName;
            return this;
        }

        public String getStoreCity() {
            return storeCity;
        }

        public Builder setStoreCity(String storeCity) {
            this.storeCity = storeCity;
            return this;
        }

        public String getStoreCountry() {
            return storeCountry;
        }

        public Builder setStoreCountry(String storeCountry) {
            this.storeCountry = storeCountry;
            return this;
        }

        public int getStoreZipCode() {
            return storeZipCode;
        }

        public Builder setStoreZipCode(int storeZipCode) {
            this.storeZipCode = storeZipCode;
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
