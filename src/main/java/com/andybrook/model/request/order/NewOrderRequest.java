package com.andybrook.model.request.order;

public final class NewOrderRequest {

    private String name;
    private long storeId;
    private String comment;

    public NewOrderRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewOrderRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", customerId=").append(storeId);
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
