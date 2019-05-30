package com.andybrook.model.request.customer;

import com.andybrook.model.common.Address;

public final class UpdateCustomerRequest {

    private final long customerId;
    private final String ownerCompagnyName;
    private final String ownerFirstName;
    private final String ownerLastName;
    private final String ownerEmail;

    private final String storeName;
    private final String storePhone;
    private final String storeEmail;
    private final Address storeAddress;

    private UpdateCustomerRequest(Builder builder) {
        this.customerId = builder.customerId;
        this.storeName = builder.storeName;
        this.storePhone = builder.storePhone;
        this.storeEmail = builder.storeEmail;
        this.storeAddress = builder.storeAddress;
        this.ownerCompagnyName = builder.ownerCompagnyName;
        this.ownerFirstName = builder.ownerFirstName;
        this.ownerLastName = builder.ownerLastName;
        this.ownerEmail = builder.ownerEmail;
    }

    public static Builder builder(long customerId) {
        return new Builder(customerId);
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getOwnerCompagnyName() {
        return ownerCompagnyName;
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

    public String getStorePhone() {
        return storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public Address getStoreAddress() {
        return storeAddress;
    }

    public static class Builder {

        private long customerId;
        private String ownerCompagnyName;
        private String ownerFirstName;
        private String ownerLastName;
        private String ownerEmail;

        private String storeName;
        private String storePhone;
        private String storeEmail;
        private Address storeAddress;

        private Builder(long customerId) {
            this.customerId = customerId;
        }

        public UpdateCustomerRequest build() {
            return new UpdateCustomerRequest(this);
        }

        public long getCustomerId() {
            return customerId;
        }

        public String getOwnerCompagnyName() {
            return ownerCompagnyName;
        }

        public Builder setOwnerCompagnyName(String ownerCompagnyName) {
            this.ownerCompagnyName = ownerCompagnyName;
            return this;
        }

        public String getOwnerFirstName() {
            return ownerFirstName;
        }

        public Builder setOwnerFirstName(String ownerFirstName) {
            this.ownerFirstName = ownerFirstName;
            return this;
        }

        public String getOwnerLastName() {
            return ownerLastName;
        }

        public Builder setOwnerLastName(String ownerLastName) {
            this.ownerLastName = ownerLastName;
            return this;
        }

        public String getOwnerEmail() {
            return ownerEmail;
        }

        public Builder setOwnerEmail(String ownerEmail) {
            this.ownerEmail = ownerEmail;
            return this;
        }

        public String getStoreName() {
            return storeName;
        }

        public Builder setStoreName(String storeName) {
            this.storeName = storeName;
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

        public Address getStoreAddress() {
            return storeAddress;
        }

        public Builder setStoreAddress(Address storeAddress) {
            this.storeAddress = storeAddress;
            return this;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateCustomerRequest{");
        sb.append("customerId=").append(customerId);
        sb.append(", ownerCompagnyName='").append(ownerCompagnyName).append('\'');
        sb.append(", ownerFirstName='").append(ownerFirstName).append('\'');
        sb.append(", ownerLastName='").append(ownerLastName).append('\'');
        sb.append(", ownerEmail='").append(ownerEmail).append('\'');
        sb.append(", storeName='").append(storeName).append('\'');
        sb.append(", storePhone='").append(storePhone).append('\'');
        sb.append(", storeEmail='").append(storeEmail).append('\'');
        sb.append(", storeAddress=").append(storeAddress);
        sb.append('}');
        return sb.toString();
    }
}
