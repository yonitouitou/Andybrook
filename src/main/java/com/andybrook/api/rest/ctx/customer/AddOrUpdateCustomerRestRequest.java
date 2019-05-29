package com.andybrook.api.rest.ctx.customer;

public class AddOrUpdateCustomerRestRequest extends CustomerRestRequest {

    private Long ownerId;
    private String ownerCompagnyName;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerEmail;

    private Long storeId;
    private String storeName;
    private String storeStreetNumber;
    private String storeStreetName;
    private String storeCity;
    private String storeCountry;
    private int storeZipCode;
    private String storePhone;
    private String storeEmail;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCompagnyName() {
        return ownerCompagnyName;
    }

    public AddOrUpdateCustomerRestRequest setOwnerCompagnyName(String ownerCompagnyName) {
        this.ownerCompagnyName = ownerCompagnyName;
        return this;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreStreetNumber() {
        return storeStreetNumber;
    }

    public AddOrUpdateCustomerRestRequest setStoreStreetNumber(String storeStreetNumber) {
        this.storeStreetNumber = storeStreetNumber;
        return this;
    }

    public String getStoreStreetName() {
        return storeStreetName;
    }

    public AddOrUpdateCustomerRestRequest setStoreStreetName(String storeStreetName) {
        this.storeStreetName = storeStreetName;
        return this;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public AddOrUpdateCustomerRestRequest setStoreCity(String storeCity) {
        this.storeCity = storeCity;
        return this;
    }

    public String getStoreCountry() {
        return storeCountry;
    }

    public AddOrUpdateCustomerRestRequest setStoreCountry(String storeCountry) {
        this.storeCountry = storeCountry;
        return this;
    }

    public int getStoreZipCode() {
        return storeZipCode;
    }

    public AddOrUpdateCustomerRestRequest setStoreZipCode(int storeZipCode) {
        this.storeZipCode = storeZipCode;
        return this;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddOrUpdateCustomerRestRequest{");
        sb.append("ownerId=").append(ownerId);
        sb.append(", ownerCompagnyName='").append(ownerCompagnyName).append('\'');
        sb.append(", ownerFirstName='").append(ownerFirstName).append('\'');
        sb.append(", ownerLastName='").append(ownerLastName).append('\'');
        sb.append(", ownerEmail='").append(ownerEmail).append('\'');
        sb.append(", storeId=").append(storeId);
        sb.append(", storeName='").append(storeName).append('\'');
        sb.append(", storeStreetNumber='").append(storeStreetNumber).append('\'');
        sb.append(", storeStreetName='").append(storeStreetName).append('\'');
        sb.append(", storeCity='").append(storeCity).append('\'');
        sb.append(", storeCountry='").append(storeCountry).append('\'');
        sb.append(", storeZipCode=").append(storeZipCode);
        sb.append(", storePhone='").append(storePhone).append('\'');
        sb.append(", storeEmail='").append(storeEmail).append('\'');
        sb.append(", customerId=").append(customerId);
        sb.append('}');
        return sb.toString();
    }
}
